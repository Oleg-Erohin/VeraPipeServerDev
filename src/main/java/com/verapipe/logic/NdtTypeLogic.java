package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.INdtTypeDal;
import com.verapipe.dto.NdtType;
import com.verapipe.entities.NdtTypeEntity;
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
public class NdtTypeLogic {
    private INdtTypeDal ndtTypeDal;

    @Autowired
    public NdtTypeLogic(INdtTypeDal ndtTypeDal) {
        this.ndtTypeDal = ndtTypeDal;
    }

    public int add(NdtType ndtType) throws Exception {
        validations(ndtType);
        NdtTypeEntity ndtTypeEntity = new NdtTypeEntity(ndtType);
        try {
            ndtTypeEntity = this.ndtTypeDal.save(ndtTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedNdtTypeId = ndtTypeEntity.getId();
        return addedNdtTypeId;
    }

    public void update(NdtType ndtType) throws Exception {
        validations(ndtType);
        NdtTypeEntity sentNdtTypeEntity = new NdtTypeEntity(ndtType);
        try {
            this.ndtTypeDal.save(sentNdtTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isNdtTypeExist(id)) {
            throw new ApplicationException(ErrorType.NDT_TYPE_DOES_NOT_EXIST);
        }
        try {
            this.ndtTypeDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_NDT_TYPE);
        }
    }

    public NdtType getById(int id) throws Exception {
        Optional<NdtTypeEntity> ndtTypeEntity;
        try {
            ndtTypeEntity = this.ndtTypeDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_TYPE_COULD_NOT_BE_FOUND);
        }
        if (ndtTypeEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.NDT_TYPE_DOES_NOT_EXIST);
        }
        NdtType ndtType = new NdtType(ndtTypeEntity.get());
        return ndtType;
    }

    @Cacheable(cacheNames = "ndtTypeCache", key = "#root.methodName")
    public List<NdtType> getAll() throws Exception {
        Iterable<NdtTypeEntity> ndtTypeEntities;
        List<NdtType> ndtTypes = new ArrayList<>();
        try{
            ndtTypeEntities = this.ndtTypeDal.findAll();
            // Convert Iterable to List
            for (NdtTypeEntity ndtTypeEntity : ndtTypeEntities
            ) {
                NdtType ndtType = new NdtType(ndtTypeEntity);
                ndtTypes.add(ndtType);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_TYPE_COULD_NOT_BE_FOUND);
        }
        return ndtTypes;
    }

    private void validations(NdtType ndtType) throws Exception {
        validateNdtTypeName(ndtType.getName());
    }

    private void validateNdtTypeName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isNdtTypeExist(int id) {
        return this.ndtTypeDal.existsById(id);
    }
}
