package com.verapipe.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.consts.Consts;
import com.verapipe.dal.IIsometricDal;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.JointEntity;
import com.verapipe.entities.PidEntity;
import com.verapipe.entities.PressureTestPackageEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.IsometricSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IsometricLogic {
    private IIsometricDal isometricDal;
    private PidLogic pidLogic;
    private IsometricSpecifications isometricSpecifications;

    @Autowired
    public IsometricLogic(IIsometricDal isometricDal, PidLogic pidLogic, IsometricSpecifications isometricSpecifications) {
        this.isometricDal = isometricDal;
        this.pidLogic = pidLogic;
        this.isometricSpecifications = isometricSpecifications;
    }

    public int add(Isometric isometric) throws Exception {
        validations(isometric);
        IsometricEntity isometricEntity = new IsometricEntity(isometric);
        try {
            isometricEntity = this.isometricDal.save(isometricEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.ISOMETRIC_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedIsometricId = isometricEntity.getId();
        return addedIsometricId;
    }

    public void update(Isometric isometric) throws Exception {
        validations(isometric);
        IsometricEntity sentIsometricEntity = new IsometricEntity(isometric);
        try {
            this.isometricDal.save(sentIsometricEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.ISOMETRIC_COULD_NOT_BE_ADDED_OR_UPDATED);

        }
    }

    public void delete(int id) throws Exception {
        if (!isIsometricExist(id)) {
            throw new ApplicationException(ErrorType.ISOMETRIC_DOES_NOT_EXIST);
        }
        try {
            this.isometricDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_ISOMETRIC);
        }
    }

    public Isometric getById(int id) throws Exception {
        Optional<IsometricEntity> isometricEntity;
        try {
            isometricEntity = this.isometricDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.ISOMETRIC_COULD_NOT_BE_FOUND);
        }
        if (isometricEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.ISOMETRIC_DOES_NOT_EXIST);
        }
        Isometric isometric = new Isometric(isometricEntity.get());
        return isometric;
    }

    public List<Isometric> getAll() throws Exception {
        Iterable<IsometricEntity> isometricEntities;
        List<Isometric> isometrics = new ArrayList<>();
        try{
            isometricEntities = this.isometricDal.findAll();
            // Convert Iterable to List
            for (IsometricEntity isometricEntity : isometricEntities
            ) {
                Isometric isometric = new Isometric(isometricEntity);
                isometrics.add(isometric);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.ISOMETRIC_COULD_NOT_BE_FOUND);
        }
        return isometrics;
    }

    public List<Isometric> findIsometricsByFilters(List<String> names, List<String> revisions, List<Date> dates, List<Integer> sheets, List<String> coordinatesInPid, Boolean isApproved, List<String> comments, Set<PidEntity> pids, List<JointEntity> joints, Set<PressureTestPackageEntity> testPacks) throws JsonProcessingException {
        Specification<IsometricEntity> spec = Specification
                .where(isometricSpecifications.hasNameIn(names))
                .and(isometricSpecifications.hasRevisionIn(revisions))
                .and(isometricSpecifications.hasDateIn(dates))
                .and(isometricSpecifications.hasSheetsIn(sheets))
                .and(isometricSpecifications.hasCoordinatesInPidIn(coordinatesInPid))
                .and(isometricSpecifications.hasIsApproved(isApproved))
                .and(isometricSpecifications.hasCommentsIn(comments))
                .and(isometricSpecifications.hasPidsIn(pids))
                .and(isometricSpecifications.hasJointsIn(joints))
                .and(isometricSpecifications.hasTestPacksIn(testPacks));
        List<IsometricEntity> isometricEntities = this.isometricDal.findAll(spec);
        List<Isometric> isometrics = convertEntityListToDtoList(isometricEntities);
        return isometrics;
    }

    private List<Isometric> convertEntityListToDtoList(List<IsometricEntity> isometricEntities) throws JsonProcessingException {
        List<Isometric> isometrics = new ArrayList<>();
        for (IsometricEntity entity : isometricEntities
             ) {
            Isometric isometric = new Isometric(entity);
            isometrics.add(isometric);
        }
        return isometrics;
    }


    private void validations(Isometric isometric) throws Exception {
        validateIsometricName(isometric.getName());

        if (isometric.getPidsAndSheets() != null) {
            validateIsometricPidSheets(isometric.getPidsAndSheets());
        }

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

    //    private void validateIsometricPidSheets(List<String> pidNames, Map<String, List<Integer>> pidSheets) throws Exception {
    private void validateIsometricPidSheets(Map<String, List<Integer>> pidSheets) throws Exception {
//        for (String pidName : pidSheets.keySet()) {
//            if (!pidNames.contains(pidName)) {
////          TODO throw new ApplicationException
//                throw new Exception("Mismatch with reference between P&ID name and sheets");
//            }
//        }

        List<Pid> allPids = pidLogic.getAll();
        List<Pid> pidsRelatedToCurrentIsometric = new ArrayList<>();

        for (Pid pid : allPids) {
//            if (pidNames.contains(pid.getName())) {
            if (pidSheets.keySet().contains(pid.getName())) {
                pidsRelatedToCurrentIsometric.add(pid);
            }
        }

        for (Pid pid : pidsRelatedToCurrentIsometric) {
            List<Integer> currentSheets = pidSheets.get(pid.getName());
            for (Integer sheet : currentSheets) {
                if (sheet < 0 || sheet > pid.getSheets()) {
                    throw new ApplicationException(ErrorType.SHEETS_DO_NOT_MATCH_PID);
                }
            }
        }
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
