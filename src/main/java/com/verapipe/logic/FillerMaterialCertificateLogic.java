package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IFillerMaterialCertificateDal;
import com.verapipe.dto.FillerMaterialCertificate;
import com.verapipe.entities.FillerMaterialCertificateEntity;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
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

    public int add(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
        FillerMaterialCertificateEntity fillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
        try {
            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.save(fillerMaterialCertificateEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedFillerMaterialCertificateId = fillerMaterialCertificateEntity.getId();
        return addedFillerMaterialCertificateId;
    }

    public void update(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
        FillerMaterialCertificateEntity sentFillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
        FillerMaterialCertificateEntity receivedFillerMaterialCertificateEntity;
        try {
            receivedFillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.save(sentFillerMaterialCertificateEntity);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentFillerMaterialCertificateEntity.equals(receivedFillerMaterialCertificateEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isFillerMaterialCertificateExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.fillerMaterialCertificateDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public FillerMaterialCertificate getById(int id) throws Exception {
        Optional<FillerMaterialCertificateEntity> fillerMaterialCertificateEntity;
        try {
            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (fillerMaterialCertificateEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Filler material certificate not found");
        }
        FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntity.get());
        return fillerMaterialCertificate;
    }

    public List<FillerMaterialCertificate> getAll() throws Exception {
        Iterable<FillerMaterialCertificateEntity> fillerMaterialCertificateEntities = this.fillerMaterialCertificateDal.findAll();
        List<FillerMaterialCertificate> fillerMaterialCertificates = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!fillerMaterialCertificateEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Filler Material Certificate list is empty");
        }
        // Convert Iterable to List
        for (FillerMaterialCertificateEntity fillerMaterialCertificateEntity : fillerMaterialCertificateEntities
        ) {
            FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntity);
            fillerMaterialCertificates.add(fillerMaterialCertificate);
        }
        return fillerMaterialCertificates;
    }


    private void validations(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validateFillerMaterialCertificateHeatNum(fillerMaterialCertificate.getHeatNum());
        validateFillerMaterialCertificateFile(fillerMaterialCertificate.getFile());
        validateFillerMaterialCertificateMaterialTypeName(fillerMaterialCertificate.getMaterialTypeName());
    }

    private void validateFillerMaterialCertificateFile(byte[] file) throws Exception {
        CommonValidations.validateFileMaxSize(file);
    }

    private void validateFillerMaterialCertificateMaterialTypeName(String materialTypeName) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(materialTypeName);
    }

    private void validateFillerMaterialCertificateHeatNum(String heatNum) throws ApplicationException {
        CommonValidations.validateStringLength(heatNum, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isFillerMaterialCertificateExist(int id) {
        return this.fillerMaterialCertificateDal.existsById(id);
    }
}
