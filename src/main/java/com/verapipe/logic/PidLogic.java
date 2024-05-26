package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPidDal;
import com.verapipe.dto.Pid;
import com.verapipe.entities.PidEntity;
import com.verapipe.enums.FileTypes;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PidLogic {
    private IPidDal pidDal;

    @Autowired
    public PidLogic(IPidDal pidDal) {
        this.pidDal = pidDal;
    }

    public int add(Pid pid) throws Exception {
        validations(pid);
        PidEntity pidEntity = new PidEntity(pid);
        try {
            pidEntity = this.pidDal.save(pidEntity);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedPidId = pidEntity.getId();
        return addedPidId;
    }

    public void update(Pid pid) throws Exception {
        validations(pid);
        PidEntity sentPidEntity = new PidEntity(pid);
        PidEntity receivedPidEntity;
        try {
            receivedPidEntity = this.pidDal.save(sentPidEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentPidEntity.equals(receivedPidEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isPidExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.pidDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public Pid getById(int id) throws Exception {
        Optional<PidEntity> pidEntity;
        try {
            pidEntity = this.pidDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (pidEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Pid not found");
        }
        Pid pid = new Pid(pidEntity.get());
        return pid;
    }

    public List<Pid> getAll() throws Exception {
        Iterable<PidEntity> pidEntities = this.pidDal.findAll();
        List<Pid> pids = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!pidEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Pid list is empty");
        }
        // Convert Iterable to List
        for (PidEntity pidEntity : pidEntities
        ) {
            Pid pid = new Pid(pidEntity);
            pids.add(pid);
        }
        return pids;
    }

    private void validations(Pid pid) throws Exception {
        validatePidName(pid.getName());
        validatePidFile(pid.getFile());
        validatePidRevision(pid.getRevision());
        validatePidDate(pid.getDate());
//        validatePidSheets(pid.getSheets());
//        validatePidComments(pid.getComments());
    }

    private void validatePidDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);

    }

    private void validatePidFile(byte[] file) throws Exception {
        CommonValidations.validateFileType(file, FileTypes.PDF);
        CommonValidations.validateFileMaxSize(file);
    }

    private void validatePidRevision(String revision) throws ApplicationException {
        CommonValidations.validateStringLength(revision, Consts.revisionLengthMin, Consts.revisionLengthMax);
    }

    private void validatePidName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isPidExist(int id) {
        return this.pidDal.existsById(id);
    }
}
