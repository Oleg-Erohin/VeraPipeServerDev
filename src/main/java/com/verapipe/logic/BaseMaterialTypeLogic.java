package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IBaseMaterialTypeDal;
import com.verapipe.dto.BaseMaterialType;
import com.verapipe.entities.BaseMaterialTypeEntity;
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
public class BaseMaterialTypeLogic {
    private IBaseMaterialTypeDal baseMaterialTypeDal;

    @Autowired
    public BaseMaterialTypeLogic(IBaseMaterialTypeDal baseMaterialTypeDal) {
        this.baseMaterialTypeDal = baseMaterialTypeDal;
    }

    public int add(BaseMaterialType baseMaterialType) throws Exception {
        validations(baseMaterialType);
        BaseMaterialTypeEntity baseMaterialTypeEntity = new BaseMaterialTypeEntity(baseMaterialType);
        try {
            baseMaterialTypeEntity = this.baseMaterialTypeDal.save(baseMaterialTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedBaseMaterialTypeId = baseMaterialTypeEntity.getId();
        return addedBaseMaterialTypeId;
    }

    public void update(BaseMaterialType baseMaterialType) throws Exception {
        validations(baseMaterialType);
        BaseMaterialTypeEntity sentBaseMaterialTypeEntity = new BaseMaterialTypeEntity(baseMaterialType);
        try {
            this.baseMaterialTypeDal.save(sentBaseMaterialTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isBaseMaterialTypeExist(id)) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_DOES_NOT_EXIST);
        }
        try {
            this.baseMaterialTypeDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_BASE_MATERIAL_TYPE);
        }
    }

    public BaseMaterialType getById(int id) throws Exception {
        Optional<BaseMaterialTypeEntity> baseMaterialTypeEntity;
        try {
            baseMaterialTypeEntity = this.baseMaterialTypeDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_COULD_NOT_BE_FOUND);
        }
        if (baseMaterialTypeEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_DOES_NOT_EXIST);
        }
        BaseMaterialType baseMaterialType = new BaseMaterialType(baseMaterialTypeEntity.get());
        return baseMaterialType;
    }

    @Cacheable(cacheNames = "baseMaterialTypesCache", key = "#root.methodName")
    public List<BaseMaterialType> getAll() throws Exception {
        Iterable<BaseMaterialTypeEntity> baseMaterialTypeEntities;
        List<BaseMaterialType> baseMaterialTypes = new ArrayList<>();
        try{
            baseMaterialTypeEntities = this.baseMaterialTypeDal.findAll();
            // Convert Iterable to List
            for (BaseMaterialTypeEntity baseMaterialTypeEntity : baseMaterialTypeEntities
            ) {
                BaseMaterialType baseMaterialType = new BaseMaterialType(baseMaterialTypeEntity);
                baseMaterialTypes.add(baseMaterialType);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_COULD_NOT_BE_FOUND);
        }
        return baseMaterialTypes;
    }


    private void validations(BaseMaterialType baseMaterialType) throws Exception {
        validateBaseMaterialTypeName(baseMaterialType.getName());
    }

    private void validateBaseMaterialTypeName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isBaseMaterialTypeExist(int id) {
        return this.baseMaterialTypeDal.existsById(id);
    }
}
