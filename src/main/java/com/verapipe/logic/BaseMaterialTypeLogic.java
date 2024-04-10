package com.verapipe.logic;

import com.verapipe.dal.IBaseMaterialTypeDal;
import com.verapipe.dto.BaseMaterialCertificate;
import com.verapipe.dto.BaseMaterialType;
import com.verapipe.entities.BaseMaterialCertificateEntity;
import com.verapipe.entities.BaseMaterialTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
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

    public int add (BaseMaterialType baseMaterialType) throws Exception {
        validations(baseMaterialType);
////      TODO Cancel comment after entity constructor has made
//        BaseMaterialTypeEntity baseMaterialTypeEntity = new BaseMaterialTypeEntity(baseMaterialType);
//        try{
//            baseMaterialTypeEntity = this.baseMaterialTypeDal.save(baseMaterialTypeEntity);
//        }
//        catch (Exception e){
////          TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        int addedBaseMaterialTypeId = baseMaterialTypeEntity.getId();
//        return addedBaseMaterialTypeId;
//          TODO delete return 0 after original return is valid;
        return 0;
    }

    public void update (BaseMaterialType baseMaterialType) throws Exception {
        validations(baseMaterialType);
////        TODO Cancel comment after entity constructor has made
//        BaseMaterialTypeEntity sentBaseMaterialTypeEntity = new BaseMaterialTypeEntity(baseMaterialType);
//        BaseMaterialTypeEntity receivedBaseMaterialTypeEntity;
//        try {
//            receivedBaseMaterialTypeEntity = this.baseMaterialTypeDal.save(sentBaseMaterialTypeEntity);
//        } catch (Exception e) {
////          TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        // Validate sent entity and return entity from DB are equals
//        if (!sentBaseMaterialTypeEntity.equals(receivedBaseMaterialTypeEntity)) {
////            TODO throw new ApplicationException
//            throw new Exception();
//        }
    }

    public void delete (int id) throws Exception {
//        if (!isBaseMaterialTypeExist(id)) {
////            TODO throw new ApplicationException
//        }
//        try {
//            this.baseMaterialTypeDal.deleteById(id);
//        } catch (Exception e) {
////            TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
    }

    public BaseMaterialType getById(int id) throws Exception {
//        Optional<BaseMaterialTypeEntity> baseMaterialTypeEntity;
//        try {
//            baseMaterialTypeEntity = this.baseMaterialTypeDal.findById(id);
//        } catch (Exception e) {
////            TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        if (baseMaterialTypeEntity.isEmpty()) {
////            TODO throw new ApplicationException
//            throw new Exception("Base Material Type not found");
//        }
////        TODO Cancel comment after entity constructor has made
//        BaseMaterialType baseMaterialType = new BaseMaterialType(baseMaterialTypeEntity);
//        return baseMaterialType;
//          TODO delete return new after original return is valid;
        return new BaseMaterialType();
    }

    public List<BaseMaterialType> getAll() throws Exception {
        Iterable<BaseMaterialTypeEntity> baseMaterialTypeEntities = this.baseMaterialTypeDal.findAll();
        List<BaseMaterialType> baseMaterialTypes = new ArrayList<>();
        // Check if the findAll method returned a value
//        if (!baseMaterialTypeEntities.iterator().hasNext()){
////          TODO throw new ApplicationException
//            throw new Exception("Base Material Type list is empty");
//        }
//        // Convert Iterable to List
////      TODO Cancel comment after entity constructor has made
//        for (BaseMaterialTypeEntity baseMaterialTypeEntity: baseMaterialTypeEntities
//             ) {
//            BaseMaterialType baseMaterialType = new BaseMaterialType(baseMaterialTypeEntity);
//            baseMaterialTypes.add(baseMaterialType);
//        }
        return baseMaterialTypes;
    }


    private void validations(BaseMaterialType baseMaterialType) throws Exception {
//      TODO Create validations
    }

    private boolean isBaseMaterialTypeExist(int id) {
        return this.baseMaterialTypeDal.existsById(id);
    }
}
