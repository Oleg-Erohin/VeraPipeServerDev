//package com.verapipe.logic;
//
//import com.sun.xml.bind.v2.TODO;
//import com.verapipe.dal.IFillerMaterialTypeDal;
//import com.verapipe.dto.FillerMaterialCertificate;
//import com.verapipe.dto.FillerMaterialType;
//import com.verapipe.entities.FillerMaterialCertificateEntity;
//import com.verapipe.entities.FillerMaterialTypeEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FillerMaterialTypeLogic {
//    private IFillerMaterialTypeDal fillerMaterialTypeDal;
//
//    @Autowired
//    public FillerMaterialTypeLogic(IFillerMaterialTypeDal fillerMaterialTypeDal) {
//        this.fillerMaterialTypeDal = fillerMaterialTypeDal;
//    }
//
//
//
//    public int add (FillerMaterialType fillerMaterialType) throws Exception {
//        validations(fillerMaterialType);
//////      TODO Cancel comment after entity constructor has made
////        FillerMaterialTypeEntity fillerMaterialTypeEntity = new FillerMaterialCertificateEntity(fillerMaterialType);
////        try{
////            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.save(fillerMaterialTypeEntity);
////        }
////        catch (Exception e){
//////          TODO throw new ApplicationException
////            throw new Exception(e.getMessage());
////        }
////        int addedFillerMaterialTypeId = fillerMaterialTypeEntity.getId();
////        return addedFillerMaterialTypeId;
////          TODO delete return 0 after original return is valid;
//        return 0;
//    }
//
//    public void update (FillerMaterialType fillerMaterialType) throws Exception {
//        validations(fillerMaterialType);
//////        TODO Cancel comment after entity constructor has made
////        FillerMaterialTypeEntity sentFillerMaterialTypeEntity = new FillerMaterialTypeEntity(fillerMaterialType);
////        FillerMaterialTypeEntity receivedFillerMaterialTypeEntity;
////        try {
////            receivedFillerMaterialTypeEntity = this.fillerMaterialTypeDal.save(sentFillerMaterialTypeEntity);
////        } catch (Exception e) {
//////          TODO throw new ApplicationException
////            throw new Exception(e.getMessage());
////        }
////        // Validate sent entity and return entity from DB are equals
////        if (!sentFillerMaterialTypeEntity.equals(receivedFillerMaterialTypeEntity)) {
//////            TODO throw new ApplicationException
////            throw new Exception();
////        }
//    }
//
//    public void delete (int id) throws Exception {
////        if (!isFillerMaterialTypeExist(id)) {
//////            TODO throw new ApplicationException
////        }
////        try {
////            this.fillerMaterialTypeDal.deleteById(id);
////        } catch (Exception e) {
//////            TODO throw new ApplicationException
////            throw new Exception(e.getMessage());
////        }
//    }
//
//    public FillerMaterialType getById(int id) throws Exception {
////        Optional<FillerMaterialTypeEntity> fillerMaterialTypeEntity;
////        try {
////            fillerMaterialTypeEntity = this.fillerMaterialTypeDal.findById(id);
////        } catch (Exception e) {
//////            TODO throw new ApplicationException
////            throw new Exception(e.getMessage());
////        }
////        if (fillerMaterialTypeEntity.isEmpty()) {
//////            TODO throw new ApplicationException
////            throw new Exception("Filler material type not found");
////        }
//////        TODO Cancel comment after entity constructor has made
////        FillerMaterialType fillerMaterialType = new FillerMaterialType(fillerMaterialTypeEntity);
////        return fillerMaterialType;
////          TODO delete return new after original return is valid;
//        return new FillerMaterialType();
//    }
//
//    public List<FillerMaterialType> getAll() throws Exception {
//        Iterable<FillerMaterialTypeEntity> fillerMaterialTypeEntities = this.fillerMaterialTypeDal.findAll();
//        List<FillerMaterialType> fillerMaterialType = new ArrayList<>();
//        // Check if the findAll method returned a value
//        if (!fillerMaterialTypeEntities.iterator().hasNext()){
////          TODO throw new ApplicationException
//            throw new Exception("Filler Material Type list is empty");
//        }
//        // Convert Iterable to List
////      TODO Cancel comment after entity constructor has made
//        for (FillerMaterialTypeEntity fillerMaterialTypeEntities: fillerMaterialTypeEntities
//             ) {
//            FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntities);
//            fillerMaterialCertificates.add(fillerMaterialCertificate);
//        }
//        return fillerMaterialCertificates;
//    }
//
//
//    private void validations(FillerMaterialType fillerMaterialType) throws Exception {
////      TODO Create validations
//    }
//
//    private boolean isFillerMaterialTypeExist(int id) {
//        return this.fillerMaterialTypeDal.existsById(id);
//    }
//}
