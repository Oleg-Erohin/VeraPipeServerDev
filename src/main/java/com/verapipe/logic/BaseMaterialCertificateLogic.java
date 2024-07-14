package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IBaseMaterialCertificateDal;
import com.verapipe.dto.BaseMaterialCertificate;
import com.verapipe.entities.BaseMaterialCertificateEntity;
import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.JointEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.BaseMaterialCertificateSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BaseMaterialCertificateLogic {
    private IBaseMaterialCertificateDal baseMaterialCertificateDal;
    private BaseMaterialCertificateSpecifications baseMaterialCertificateSpecifications;
    private BaseMaterialTypeLogic baseMaterialTypeLogic;

    @Autowired
    public BaseMaterialCertificateLogic(IBaseMaterialCertificateDal baseMaterialCertificateDal,
                                        BaseMaterialCertificateSpecifications baseMaterialCertificateSpecifications,
                                        BaseMaterialTypeLogic baseMaterialTypeLogic
                                        ) {
        this.baseMaterialCertificateDal = baseMaterialCertificateDal;
        this.baseMaterialCertificateSpecifications = baseMaterialCertificateSpecifications;
        this.baseMaterialTypeLogic = baseMaterialTypeLogic;
    }

    public int add(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validations(baseMaterialCertificate);
        BaseMaterialCertificateEntity baseMaterialCertificateEntity = new BaseMaterialCertificateEntity(baseMaterialCertificate);
        try {
            baseMaterialCertificateEntity = this.baseMaterialCertificateDal.save(baseMaterialCertificateEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedBaseMaterialCertificateId = baseMaterialCertificateEntity.getId();
        return addedBaseMaterialCertificateId;
    }

    public void update(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validations(baseMaterialCertificate);
        BaseMaterialCertificateEntity sentBaseMaterialCertificateEntity = new BaseMaterialCertificateEntity(baseMaterialCertificate);
        try {
            this.baseMaterialCertificateDal.save(sentBaseMaterialCertificateEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isBaseMaterialCertificateExist(id)) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
        }
        try {
            this.baseMaterialCertificateDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_BASE_MATERIAL_CERTIFICATE);
        }
    }

    public BaseMaterialCertificate getById(int id) throws Exception {
        Optional<BaseMaterialCertificateEntity> baseMaterialCertificateEntity;
        try {
            baseMaterialCertificateEntity = this.baseMaterialCertificateDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_COULD_NOT_BE_FOUND);
        }
        if (baseMaterialCertificateEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
        }

        BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(baseMaterialCertificateEntity.get());
        return baseMaterialCertificate;
    }

    public List<BaseMaterialCertificate> getAll() throws Exception {
        Iterable<BaseMaterialCertificateEntity> baseMaterialCertificateEntities;
        List<BaseMaterialCertificate> baseMaterialCertificates = new ArrayList<>();
        try {
            baseMaterialCertificateEntities = this.baseMaterialCertificateDal.findAll();
            // Convert Iterable to List
            for (BaseMaterialCertificateEntity baseMaterialCertificateEntity : baseMaterialCertificateEntities
            ) {
                BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(baseMaterialCertificateEntity);
                baseMaterialCertificates.add(baseMaterialCertificate);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_COULD_NOT_BE_FOUND);
        }
        return baseMaterialCertificates;
    }

    public List<BaseMaterialCertificate> findCertificatesByFilters(String heatNum, String lotNum, BaseMaterialTypeEntity baseMaterialType, Set<JointEntity> jointsList) throws ApplicationException {
        Specification<BaseMaterialCertificateEntity> spec = Specification
                .where(baseMaterialCertificateSpecifications.hasHeatNum(heatNum))
                .and(baseMaterialCertificateSpecifications.hasLotNum(lotNum))
                .and(baseMaterialCertificateSpecifications.hasBaseMaterialType(baseMaterialType))
                .and(baseMaterialCertificateSpecifications.hasJointsIn(jointsList));

        List<BaseMaterialCertificateEntity> baseMaterialCertificateEntities;
        List<BaseMaterialCertificate> baseMaterialCertificates = new ArrayList<>();
        try {
            baseMaterialCertificateEntities = this.baseMaterialCertificateDal.findAll(spec);
            baseMaterialCertificates = convertEntityListToDtoList(baseMaterialCertificateEntities);

        } catch (Exception e) {
            throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_COULD_NOT_BE_FOUND);
        }
        return baseMaterialCertificates;
    }

    private List<BaseMaterialCertificate> convertEntityListToDtoList(List<BaseMaterialCertificateEntity> baseMaterialCertificateEntities) {
        List<BaseMaterialCertificate> baseMaterialCertificates = new ArrayList<>();
        for (BaseMaterialCertificateEntity entity : baseMaterialCertificateEntities
        ) {
            BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(entity);
            baseMaterialCertificates.add(baseMaterialCertificate);
        }
        return baseMaterialCertificates;
    }

    private void validations(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        validateBaseMaterialCertificateHeatOrLotNum(baseMaterialCertificate.getHeatNum());
        if (baseMaterialCertificate.getLotNum() != null) {
            validateBaseMaterialCertificateHeatOrLotNum(baseMaterialCertificate.getLotNum());
        }
//        validateBaseMaterialCertificateMaterialTypeName(baseMaterialCertificate.getMaterialTypeName());
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

//    private BaseMaterialCertificateEntity convertDtoToEntity(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
//        BaseMaterialCertificateEntity baseMaterialCertificateEntity = new BaseMaterialCertificateEntity(baseMaterialCertificate);
//        BaseMaterialTypeEntity baseMaterialTypeEntity = getBaseMaterialTypeByName(baseMaterialCertificate.getMaterialTypeName());
//        baseMaterialCertificateEntity.setBaseMaterialType(baseMaterialTypeEntity);
//        return baseMaterialCertificateEntity;
//    }

//    private BaseMaterialCertificate convertEntityToDto(BaseMaterialCertificateEntity baseMaterialCertificateEntity) throws Exception {
//        BaseMaterialCertificate baseMaterialCertificate = new BaseMaterialCertificate(baseMaterialCertificateEntity);
//        return baseMaterialCertificate;
//    }

    private BaseMaterialTypeEntity getBaseMaterialTypeByName(String materialTypeName) throws ApplicationException {
        return baseMaterialTypeLogic.getByName(materialTypeName);
    }
}
