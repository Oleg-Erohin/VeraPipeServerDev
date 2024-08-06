package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPidDal;
import com.verapipe.dto.Pid;
import com.verapipe.entities.PidEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.PidSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
            throw new ApplicationException(ErrorType.PID_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedPidId = pidEntity.getId();
        return addedPidId;
    }

    public void update(Pid pid) throws Exception {
        validations(pid);
        PidEntity sentPidEntity = new PidEntity(pid);
        try {
            this.pidDal.save(sentPidEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PID_COULD_NOT_BE_ADDED_OR_UPDATED);

        }
    }

    public void delete(int id) throws Exception {
        if (!isPidExist(id)) {
            throw new ApplicationException(ErrorType.PID_DOES_NOT_EXIST);
        }
        try {
            this.pidDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_PID);
        }
    }

    public Pid getById(int id) throws Exception {
        Optional<PidEntity> pidEntity;
        try {
            pidEntity = this.pidDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PID_COULD_NOT_BE_FOUND);
        }
        if (pidEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.PID_DOES_NOT_EXIST);
        }
        Pid pid = new Pid(pidEntity.get());
        return pid;
    }

    public List<Pid> getAll() throws Exception {
        Iterable<PidEntity> pidEntities;
        List<Pid> pids = new ArrayList<>();
        try{
            pidEntities = this.pidDal.findAll();
            // Convert Iterable to List
            for (PidEntity pidEntity : pidEntities
            ) {
                Pid pid = new Pid(pidEntity);
                pids.add(pid);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PID_COULD_NOT_BE_FOUND);
        }
        return pids;
    }

    public List<Pid> findPidsByFilters(Set<String> names, Set<String> revisions, Set<Date> dates) {
        Specification<PidEntity> spec = Specification
                .where(PidSpecifications.hasNames(names))
                .and(PidSpecifications.hasRevisions(revisions))
                .and(PidSpecifications.hasDates(dates));

        List<PidEntity> pidEntities = this.pidDal.findAll(spec);
        return pidEntities.stream().map(Pid::new).collect(Collectors.toList());
    }

    private void validations(Pid pid) throws Exception {
        validatePidName(pid.getName());
        validatePidRevision(pid.getRevision());
        validatePidDate(pid.getDate());
//        validatePidSheets(pid.getSheets());
        if (pid.getComments() != null) {
//        validatePidComments(pid.getComments());
        }
    }

    private void validatePidDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);

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
