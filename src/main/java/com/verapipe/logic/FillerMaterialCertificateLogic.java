package com.verapipe.logic;

import com.verapipe.dal.IBaseMaterialTypeDal;
import com.verapipe.dal.IFillerMaterialCertificateDal;
import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.FillerMaterialCertificate;
import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.FillerMaterialCertificateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FillerMaterialCertificateLogic {
    private IFillerMaterialCertificateDal fillerMaterialCertificateDal;

    @Autowired
    public FillerMaterialCertificateLogic(IFillerMaterialCertificateDal fillerMaterialCertificateDal) {
        this.fillerMaterialCertificateDal = fillerMaterialCertificateDal;
    }

    public int add (FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
////      TODO Cancel comment after entity constructor has made
//        FillerMaterialCertificateEntity fillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
//        try{
//            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.save(fillerMaterialCertificateEntity);
//        }
//        catch (Exception e){
////          TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        int addedFillerMaterialCertificateId = fillerMaterialCertificateEntity.getId();
//        return addedFillerMaterialCertificateId;
//          TODO delete return 0 after original return is valid;
        return 0;
    }

    public void update (FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
////        TODO Cancel comment after entity constructor has made
//        FillerMaterialCertificateEntity sentFillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
//        FillerMaterialCertificateEntity receivedFillerMaterialCertificateEntity;
//        try {
//            receivedFillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.save(sentFillerMaterialCertificateEntity);
//        } catch (Exception e) {
////          TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        // Validate sent entity and return entity from DB are equals
//        if (!sentFillerMaterialCertificateEntity.equals(receivedFillerMaterialCertificateEntity)) {
////            TODO throw new ApplicationException
//            throw new Exception();
//        }
    }

    public void delete (int id) throws Exception {
//        if (!isFillerMaterialCertificateExist(id)) {
////            TODO throw new ApplicationException
//        }
//        try {
//            this.fillerMaterialCertificateDal.deleteById(id);
//        } catch (Exception e) {
////            TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
    }

    public FillerMaterialCertificate getById(int id) throws Exception {
//        Optional<FillerMaterialCertificateEntity> fillerMaterialCertificateEntity;
//        try {
//            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.findById(id);
//        } catch (Exception e) {
////            TODO throw new ApplicationException
//            throw new Exception(e.getMessage());
//        }
//        if (fillerMaterialCertificateEntity.isEmpty()) {
////            TODO throw new ApplicationException
//            throw new Exception("Filler material certificate not found");
//        }
////        TODO Cancel comment after entity constructor has made
//        FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntity);
//        return fillerMaterialCertificate;
//          TODO delete return new after original return is valid;
        return new FillerMaterialCertificate();
    }

    public List<FillerMaterialCertificate> getAll() throws Exception {
        Iterable<FillerMaterialCertificateEntity> fillerMaterialCertificateEntities = this.fillerMaterialCertificateDal.findAll();
        List<FillerMaterialCertificate> fillerMaterialCertificates = new ArrayList<>();
        // Check if the findAll method returned a value
//        if (!fillerMaterialCertificateEntities.iterator().hasNext()){
////          TODO throw new ApplicationException
//            throw new Exception("Base Material Type list is empty");
//        }
//        // Convert Iterable to List
////      TODO Cancel comment after entity constructor has made
//        for (FillerMaterialCertificateEntity fillerMaterialCertificateEntity: fillerMaterialCertificateEntities
//             ) {
//            FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntities);
//            fillerMaterialCertificates.add(fillerMaterialCertificate);
//        }
        return fillerMaterialCertificates;
    }


    private void validations(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
//      TODO Create validations
    }

    private boolean isFillerMaterialCertificateExist(int id) {
        return this.fillerMaterialCertificateDal.existsById(id);
    }
}
