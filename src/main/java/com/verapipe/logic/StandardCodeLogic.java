package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IStandardCodeDal;
import com.verapipe.dto.StandardCode;
import com.verapipe.entities.StandardCodeEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
            throw new ApplicationException(ErrorType.STANDARD_CODE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedStandardCodeId = standardCodeEntity.getId();
        return addedStandardCodeId;
    }

    public void update(StandardCode standardCode) throws Exception {
        validations(standardCode);
        StandardCodeEntity sentStandardCodeEntity = new StandardCodeEntity(standardCode);

        try {
            this.standardCodeDal.save(sentStandardCodeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.STANDARD_CODE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isStandardCodeExist(id)) {
            throw new ApplicationException(ErrorType.STANDARD_CODE_DOES_NOT_EXIST);
        }
        try {
            this.standardCodeDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_STANDARD_CODE);
        }
    }

    public StandardCode getById(int id) throws Exception {
        Optional<StandardCodeEntity> standardCodeEntity;
        try {
            standardCodeEntity = this.standardCodeDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.STANDARD_CODE_COULD_NOT_BE_FOUND);
        }
        if (standardCodeEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.STANDARD_CODE_DOES_NOT_EXIST);
        }
        StandardCode standardCode = new StandardCode(standardCodeEntity.get());
        return standardCode;
    }

    @Cacheable(cacheNames = "standardCodeCache", key = "#root.methodName")
    public List<StandardCode> getAll() throws Exception {
        Iterable<StandardCodeEntity> standardCodeEntities;
        List<StandardCode> standardCodes = new ArrayList<>();
        try{
            standardCodeEntities = this.standardCodeDal.findAll();
            // Convert Iterable to List
            for (StandardCodeEntity standardCodeEntity : standardCodeEntities
            ) {
                StandardCode standardCode = new StandardCode(standardCodeEntity);
                standardCodes.add(standardCode);
            }
        } catch (Exception e) {

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
