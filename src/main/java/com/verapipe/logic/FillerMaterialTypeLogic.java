package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IFillerMaterialTypeDal;
import com.verapipe.dto.FillerMaterialType;
import com.verapipe.entities.FillerMaterialTypeEntity;
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
public class FillerMaterialTypeLogic {
    private IFillerMaterialTypeDal fillerMaterialTypeDal;

    @Autowired
    public FillerMaterialTypeLogic(IFillerMaterialTypeDal fillerMaterialTypeDal) {
        this.fillerMaterialTypeDal = fillerMaterialTypeDal;
    }


    public int add(FillerMaterialType fillerMaterialType) throws Exception {
        validations(fillerMaterialType);
        FillerMaterialTypeEntity fillerMaterialTypeEntity = new FillerMaterialTypeEntity(fillerMaterialType);
        try {
            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.save(fillerMaterialTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedFillerMaterialTypeId = fillerMaterialTypeEntity.getId();
        return addedFillerMaterialTypeId;
    }

    public void update(FillerMaterialType fillerMaterialType) throws Exception {
        validations(fillerMaterialType);
        FillerMaterialTypeEntity sentFillerMaterialTypeEntity = new FillerMaterialTypeEntity(fillerMaterialType);
        try {
            this.fillerMaterialTypeDal.save(sentFillerMaterialTypeEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isFillerMaterialTypeExist(id)) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_DOES_NOT_EXIST);
        }
        try {
            this.fillerMaterialTypeDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_FILLER_MATERIAL_TYPE);
        }
    }

    public FillerMaterialType getById(int id) throws Exception {
        Optional<FillerMaterialTypeEntity> fillerMaterialTypeEntity;
        try {
            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_COULD_NOT_BE_FOUND);
        }
        if (fillerMaterialTypeEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_DOES_NOT_EXIST);
        }
        FillerMaterialType fillerMaterialType = new FillerMaterialType(fillerMaterialTypeEntity.get());
        return fillerMaterialType;
    }

    @Cacheable(cacheNames = "fillerMaterialTypesCache", key = "#root.methodName")
    public List<FillerMaterialType> getAll() throws Exception {
        Iterable<FillerMaterialTypeEntity> fillerMaterialTypeEntities;
        List<FillerMaterialType> fillerMaterialTypes = new ArrayList<>();
        try{
            fillerMaterialTypeEntities = this.fillerMaterialTypeDal.findAll();
            // Convert Iterable to List
            for (FillerMaterialTypeEntity fillerMaterialTypeEntity : fillerMaterialTypeEntities
            ) {
                FillerMaterialType fillerMaterialType = new FillerMaterialType(fillerMaterialTypeEntity);
                fillerMaterialTypes.add(fillerMaterialType);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_COULD_NOT_BE_FOUND);
        }
        return fillerMaterialTypes;
    }


    private void validations(FillerMaterialType fillerMaterialType) throws Exception {
        validateFillerMaterialTypeName(fillerMaterialType.getName());
    }

    private void validateFillerMaterialTypeName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isFillerMaterialTypeExist(int id) {
        return this.fillerMaterialTypeDal.existsById(id);
    }
}
