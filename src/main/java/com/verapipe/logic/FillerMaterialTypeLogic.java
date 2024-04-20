package com.verapipe.logic;

import com.verapipe.dal.IFillerMaterialTypeDal;
import com.verapipe.dto.FillerMaterialType;
import com.verapipe.entities.FillerMaterialTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
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



    public int add (FillerMaterialType fillerMaterialType) throws Exception {
        validations(fillerMaterialType);
        FillerMaterialTypeEntity fillerMaterialTypeEntity = new FillerMaterialTypeEntity(fillerMaterialType);
        try{
            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.save(fillerMaterialTypeEntity);
        }
        catch (Exception e){
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedFillerMaterialTypeId = fillerMaterialTypeEntity.getId();
        return addedFillerMaterialTypeId;
    }

    public void update (FillerMaterialType fillerMaterialType) throws Exception {
        validations(fillerMaterialType);
        FillerMaterialTypeEntity sentFillerMaterialTypeEntity = new FillerMaterialTypeEntity(fillerMaterialType);
        FillerMaterialTypeEntity receivedFillerMaterialTypeEntity;
        try {
            receivedFillerMaterialTypeEntity = this.fillerMaterialTypeDal.save(sentFillerMaterialTypeEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentFillerMaterialTypeEntity.equals(receivedFillerMaterialTypeEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete (int id) throws Exception {
        if (!isFillerMaterialTypeExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.fillerMaterialTypeDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public FillerMaterialType getById(int id) throws Exception {
        Optional<FillerMaterialTypeEntity> fillerMaterialTypeEntity;
        try {
            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (fillerMaterialTypeEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Filler material type not found");
        }
        FillerMaterialType fillerMaterialType = new FillerMaterialType(fillerMaterialTypeEntity.get());
        return fillerMaterialType;
    }

    public List<FillerMaterialType> getAll() throws Exception {
        Iterable<FillerMaterialTypeEntity> fillerMaterialTypeEntities = this.fillerMaterialTypeDal.findAll();
        List<FillerMaterialType> fillerMaterialTypes = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!fillerMaterialTypeEntities.iterator().hasNext()){
//          TODO throw new ApplicationException
            throw new Exception("Filler Material Type list is empty");
        }
        // Convert Iterable to List
        for (FillerMaterialTypeEntity fillerMaterialTypeEntity: fillerMaterialTypeEntities
             ) {
            FillerMaterialType fillerMaterialType = new FillerMaterialType(fillerMaterialTypeEntity);
            fillerMaterialTypes.add(fillerMaterialType);
        }
        return fillerMaterialTypes;
    }


    private void validations(FillerMaterialType fillerMaterialType) throws Exception {
//      TODO Create validations
    }

    private boolean isFillerMaterialTypeExist(int id) {
        return this.fillerMaterialTypeDal.existsById(id);
    }
}
