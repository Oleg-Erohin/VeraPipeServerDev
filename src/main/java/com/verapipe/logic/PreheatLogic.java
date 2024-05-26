package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPreheatDal;
import com.verapipe.dto.Preheat;
import com.verapipe.entities.PreheatEntity;
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
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedPreheatId = preheatEntity.getId();
        return addedPreheatId;
    }

    public void update(Preheat preheat) throws Exception {
        validations(preheat);
        PreheatEntity sentPreheatEntity = new PreheatEntity(preheat);
        PreheatEntity receivedPreheatEntity;
        try {
            receivedPreheatEntity = this.preheatDal.save(sentPreheatEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentPreheatEntity.equals(receivedPreheatEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isPreheatExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.preheatDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public Preheat getById(int id) throws Exception {
        Optional<PreheatEntity> preheatEntity;
        try {
            preheatEntity = this.preheatDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (preheatEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Preheat not found");
        }
        Preheat preheat = new Preheat(preheatEntity.get());
        return preheat;
    }

    public List<Preheat> getAll() throws Exception {
        Iterable<PreheatEntity> preheatEntities = this.preheatDal.findAll();
        List<Preheat> preheats = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!preheatEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Preheat list is empty");
        }
        // Convert Iterable to List
        for (PreheatEntity preheatEntity : preheatEntities
        ) {
            Preheat preheat = new Preheat(preheatEntity);
            preheats.add(preheat);
        }
        return preheats;
    }

    private void validations(Preheat preheat) throws Exception {
        validatePreheatName(preheat.getName());
        validatePreheatProcessSpecificationProcedure(preheat.getProcessSpecificationProcedureName());
        validatePreheatFile(preheat.getFile());
        validatePreheatDate(preheat.getDate());
    }

    private void validatePreheatDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validatePreheatFile(byte[] file) throws Exception {
        CommonValidations.validateFileType(file, FileTypes.PDF);
        CommonValidations.validateFileMaxSize(file);
    }

    private void validatePreheatProcessSpecificationProcedure(String processSpecificationProcedureName) throws Exception {
        CommonValidations.validateIsExistInProcessSpecificationProcedures(processSpecificationProcedureName);
    }

    private void validatePreheatName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isPreheatExist(int id) {
        return this.preheatDal.existsById(id);
    }
}
