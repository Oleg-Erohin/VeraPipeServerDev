package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IIsometricDal;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.enums.FileTypes;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IsometricLogic {
    private IIsometricDal isometricDal;
    private PidLogic pidLogic;

    @Autowired
    public IsometricLogic(IIsometricDal isometricDal, PidLogic pidLogic) {
        this.isometricDal = isometricDal;
        this.pidLogic = pidLogic;
    }

    public int add(Isometric isometric) throws Exception {
        validations(isometric);
        IsometricEntity isometricEntity = new IsometricEntity(isometric);
        try {
            isometricEntity = this.isometricDal.save(isometricEntity);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedIsometricId = isometricEntity.getId();
        return addedIsometricId;
    }

    public void update(Isometric isometric) throws Exception {
        validations(isometric);
        IsometricEntity sentIsometricEntity = new IsometricEntity(isometric);
        IsometricEntity receivedIsometricEntity;
        try {
            receivedIsometricEntity = this.isometricDal.save(sentIsometricEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentIsometricEntity.equals(receivedIsometricEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isIsometricExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.isometricDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public Isometric getById(int id) throws Exception {
        Optional<IsometricEntity> isometricEntity;
        try {
            isometricEntity = this.isometricDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (isometricEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Isometric not found");
        }
        Isometric isometric = new Isometric(isometricEntity.get());
        return isometric;
    }

    public List<Isometric> getAll() throws Exception {
        Iterable<IsometricEntity> isometricEntities = this.isometricDal.findAll();
        List<Isometric> isometrics = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!isometricEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Isometrics list is empty");
        }
        // Convert Iterable to List
        for (IsometricEntity isometricEntity : isometricEntities
        ) {
            Isometric isometric = new Isometric(isometricEntity);
            isometrics.add(isometric);
        }
        return isometrics;
    }


    private void validations(Isometric isometric) throws Exception {
        validateIsometricName(isometric.getName());
        if (isometric.getPidNames() != null) {
            validateIsometricPidNames(isometric.getPidNames());
            if (isometric.getPidSheets() != null) {
                validateIsometricPidSheets(isometric.getPidNames(), isometric.getPidSheets());
            }
        }
        validateIsometricFile(isometric.getFile());
        validateIsometricRevision(isometric.getRevision());
        validateIsometricDate(isometric.getDate());
//        validateIsometricSheets(isometric.getSheets());
        if (isometric.getCoordinatesInPid() != null) {
//        validateIsometricCoordinatesInPid(isometric.getCoordinatesInPid());
        }
//        validateIsometricIsApproves(isometric.isApproved());
        if (isometric.getComments() != null) {
//        validateIsometricComments(isometric.getComments());
        }
    }

    private void validateIsometricDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validateIsometricPidSheets(List<String> pidNames, Map<String, List<Integer>> pidSheets) throws Exception {
        for (String pidName : pidSheets.keySet()) {
            if (!pidNames.contains(pidName)) {
//          TODO throw new ApplicationException
                throw new Exception("Mismatch with reference between P&ID name and sheets");
            }
        }

        List<Pid> allPids = pidLogic.getAll();
        List<Pid> pidsRelatedToCurrentIsometric = new ArrayList<>();

        for (Pid pid : allPids) {
            if (pidNames.contains(pid.getName())) {
                pidsRelatedToCurrentIsometric.add(pid);
            }
        }

        for (Pid pid : pidsRelatedToCurrentIsometric) {
            List<Integer> currentSheets = pidSheets.get(pid.getName());
            for (Integer sheet : currentSheets) {
                if (sheet < 0 || sheet > pid.getSheets()) {
//          TODO throw new ApplicationException
                    throw new Exception("Sheet numbers do not match the sheets of the P&ID");
                }
            }
        }
    }

    private void validateIsometricFile(byte[] file) throws Exception {
        CommonValidations.validateFileType(file, FileTypes.PDF);
        CommonValidations.validateFileMaxSize(file);
    }

    private void validateIsometricPidNames(List<String> pidNames) throws Exception {
        for (String pidName : pidNames) {
            CommonValidations.validateIsExistInPids(pidName);
        }
    }

    private void validateIsometricRevision(String revision) throws ApplicationException {
        CommonValidations.validateStringLength(revision, Consts.revisionLengthMin, Consts.revisionLengthMax);
    }

    private void validateIsometricName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isIsometricExist(int id) {
        return this.isometricDal.existsById(id);
    }
}
