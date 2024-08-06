package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPreheatDal;
import com.verapipe.dto.Preheat;
import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.entities.PreheatEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.PreheatSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PreheatLogic {
    private IPreheatDal preheatDal;

    @Autowired
    public PreheatLogic(IPreheatDal preheatDal) {
        this.preheatDal = preheatDal;
    }

    public int add(Preheat preheat) throws Exception {
        validations(preheat);
        PreheatEntity preheatEntity = new PreheatEntity(preheat);
        try {
            preheatEntity = this.preheatDal.save(preheatEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PREHEAT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedPreheatId = preheatEntity.getId();
        return addedPreheatId;
    }

    public void update(Preheat preheat) throws Exception {
        validations(preheat);
        PreheatEntity sentPreheatEntity = new PreheatEntity(preheat);
        try {
            this.preheatDal.save(sentPreheatEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PREHEAT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isPreheatExist(id)) {
            throw new ApplicationException(ErrorType.PREHEAT_DOES_NOT_EXIST);
        }
        try {
            this.preheatDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_PREHEAT);
        }
    }

    public Preheat getById(int id) throws Exception {
        Optional<PreheatEntity> preheatEntity;
        try {
            preheatEntity = this.preheatDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PREHEAT_COULD_NOT_BE_FOUND);
        }
        if (preheatEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.PREHEAT_DOES_NOT_EXIST);
        }
        Preheat preheat = new Preheat(preheatEntity.get());
        return preheat;
    }

    public List<Preheat> getAll() throws Exception {
        Iterable<PreheatEntity> preheatEntities;
        List<Preheat> preheats = new ArrayList<>();
        try {
            preheatEntities = this.preheatDal.findAll();
            // Convert Iterable to List
            for (PreheatEntity preheatEntity : preheatEntities
            ) {
                Preheat preheat = new Preheat(preheatEntity);
                preheats.add(preheat);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PREHEAT_COULD_NOT_BE_FOUND);
        }

        return preheats;
    }

    public List<Preheat> findPreheatsByFilters(Set<String> names, Set<ProcessSpecificationProcedure> processSpecificationProcedures, Set<Date> dates) {
        Specification<PreheatEntity> spec = Specification
                .where(PreheatSpecifications.hasNames(names))
                .and(PreheatSpecifications.hasProcessSpecificationProcedures(processSpecificationProcedures))
                .and(PreheatSpecifications.hasDates(dates));

        List<PreheatEntity> preheatEntities = this.preheatDal.findAll(spec);
        return preheatEntities.stream().map(Preheat::new).collect(Collectors.toList());
    }

    private void validations(Preheat preheat) throws Exception {
        validatePreheatName(preheat.getName());
        validatePreheatProcessSpecificationProcedure(preheat.getProcessSpecificationProcedure());
        validatePreheatDate(preheat.getDate());
    }

    private void validatePreheatDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validatePreheatProcessSpecificationProcedure(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        CommonValidations.validateIsExistInProcessSpecificationProcedures(processSpecificationProcedure);
    }

    private void validatePreheatName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isPreheatExist(int id) {
        return this.preheatDal.existsById(id);
    }
}
