package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IStandardCodeDal;
import com.verapipe.dto.StandardCode;
import com.verapipe.entities.StandardCodeEntity;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StandardCodeLogic {
    private IStandardCodeDal standardCodeDal;

    @Autowired
    public StandardCodeLogic(IStandardCodeDal standardCodeDal) {
        this.standardCodeDal = standardCodeDal;
    }

    public int add(StandardCode standardCode) throws Exception {
        validations(standardCode);
        StandardCodeEntity standardCodeEntity = new StandardCodeEntity(standardCode);
        try {
            standardCodeEntity = this.standardCodeDal.save(standardCodeEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedStandardCodeId = standardCodeEntity.getId();
        return addedStandardCodeId;
    }

    public void update(StandardCode standardCode) throws Exception {
        validations(standardCode);
        StandardCodeEntity sentStandardCodeEntity = new StandardCodeEntity(standardCode);
        StandardCodeEntity receivedStandardCodeEntity;
        try {
            receivedStandardCodeEntity = this.standardCodeDal.save(sentStandardCodeEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentStandardCodeEntity.equals(receivedStandardCodeEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isStandardCodeExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.standardCodeDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public StandardCode getById(int id) throws Exception {
        Optional<StandardCodeEntity> standardCodeEntity;
        try {
            standardCodeEntity = this.standardCodeDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (standardCodeEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Standard Code not found");
        }
        StandardCode standardCode = new StandardCode(standardCodeEntity.get());
        return standardCode;
    }

    public List<StandardCode> getAll() throws Exception {
        Iterable<StandardCodeEntity> standardCodeEntities = this.standardCodeDal.findAll();
        List<StandardCode> standardCodes = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!standardCodeEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Standard Code list is empty");
        }
        // Convert Iterable to List
        for (StandardCodeEntity standardCodeEntity : standardCodeEntities
        ) {
            StandardCode standardCode = new StandardCode(standardCodeEntity);
            standardCodes.add(standardCode);
        }
        return standardCodes;
    }

    private void validations(StandardCode standardCode) throws Exception {
        validateStandardCodeName(standardCode.getName());
    }

    private void validateStandardCodeName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isStandardCodeExist(int id) {
        return this.standardCodeDal.existsById(id);
    }
}
