package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IBaseMaterialCertificateDal;
import com.verapipe.dto.BaseMaterialCertificate;
import com.verapipe.entities.BaseMaterialCertificateEntity;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseMaterialCertificateLogic {
    private IBaseMaterialCertificateDal baseMaterialCertificateDal;

    @Autowired
    public BaseMaterialCertificateLogic(IBaseMaterialCertificateDal baseMaterialCertificateDal) {
        this.baseMaterialCertificateDal = baseMaterialCertificateDal;
    }

    public int add(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validations(baseMaterialCertificate);
        BaseMaterialCertificateEntity baseMaterialCertificateEntity = new BaseMaterialCertificateEntity(baseMaterialCertificate);
        try {
            baseMaterialCertificateEntity = this.baseMaterialCertificateDal.save(baseMaterialCertificateEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedBaseMaterialCertificateId = baseMaterialCertificateEntity.getId();
        return addedBaseMaterialCertificateId;
    }

    public void update(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validations(baseMaterialCertificate);
        BaseMaterialCertificateEntity sentBaseMaterialCertificateEntity = new BaseMaterialCertificateEntity(baseMaterialCertificate);
        BaseMaterialCertificateEntity receivedBaseMaterialCertificateEntity;
        try {
            receivedBaseMaterialCertificateEntity = this.baseMaterialCertificateDal.save(sentBaseMaterialCertificateEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentBaseMaterialCertificateEntity.equals(receivedBaseMaterialCertificateEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isBaseMaterialCertificateExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.baseMaterialCertificateDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public BaseMaterialCertificate getById(int id) throws Exception {
        Optional<BaseMaterialCertificateEntity> baseMaterialCertificateEntity;
        try {
            baseMaterialCertificateEntity = this.baseMaterialCertificateDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (baseMaterialCertificateEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Base Material Certificate not found");
        }
        BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(baseMaterialCertificateEntity.get());
        return baseMaterialCertificate;
    }

    public List<BaseMaterialCertificate> getAll() throws Exception {
        Iterable<BaseMaterialCertificateEntity> baseMaterialCertificateEntities = this.baseMaterialCertificateDal.findAll();
        List<BaseMaterialCertificate> baseMaterialCertificates = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!baseMaterialCertificateEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Base Material Certificate list is empty");
        }
        // Convert Iterable to List
        for (BaseMaterialCertificateEntity baseMaterialCertificateEntity : baseMaterialCertificateEntities
        ) {
            BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(baseMaterialCertificateEntity);
            baseMaterialCertificates.add(baseMaterialCertificate);
        }
        return baseMaterialCertificates;
    }


    private void validations(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validateBaseMaterialCertificateHeatOrLotNum(baseMaterialCertificate.getHeatNum());
        validateBaseMaterialCertificateHeatOrLotNum(baseMaterialCertificate.getLotNum());
//        validateBaseMaterialCertificateFile(baseMaterialCertificate.getFile());
        validateBaseMaterialCertificateMaterialTypeName(baseMaterialCertificate.getMaterialTypeName());
    }

    private void validateBaseMaterialCertificateMaterialTypeName(String materialTypeName) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(materialTypeName);
    }

    private void validateBaseMaterialCertificateHeatOrLotNum(String heatOrLotNum) throws ApplicationException {
        CommonValidations.validateStringLength(heatOrLotNum, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isBaseMaterialCertificateExist(int id) {
        return this.baseMaterialCertificateDal.existsById(id);
    }
}
