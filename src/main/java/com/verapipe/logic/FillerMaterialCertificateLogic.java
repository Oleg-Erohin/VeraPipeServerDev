package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IFillerMaterialCertificateDal;
import com.verapipe.dto.FillerMaterialCertificate;
import com.verapipe.dto.FillerMaterialType;
import com.verapipe.entities.FillerMaterialCertificateEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.enums.FileType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.FillerMaterialCertificateSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FillerMaterialCertificateLogic {
    private IFillerMaterialCertificateDal fillerMaterialCertificateDal;
    private FillerMaterialCertificateSpecifications fillerMaterialCertificateSpecifications;
    private FileLogic fileLogic;

    @Autowired
    public FillerMaterialCertificateLogic(IFillerMaterialCertificateDal fillerMaterialCertificateDal,
                                          FillerMaterialCertificateSpecifications fillerMaterialCertificateSpecifications
    ) {
        this.fillerMaterialCertificateDal = fillerMaterialCertificateDal;
        this.fillerMaterialCertificateSpecifications = fillerMaterialCertificateSpecifications;
    }

    @CacheEvict(cacheNames = "fillerMaterialCertificatesCache", allEntries = true)
    public int add(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
        FillerMaterialCertificateEntity fillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
        try {
            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.save(fillerMaterialCertificateEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedFillerMaterialCertificateId = fillerMaterialCertificateEntity.getId();
        return addedFillerMaterialCertificateId;
    }

    @CacheEvict(cacheNames = "fillerMaterialCertificatesCache", allEntries = true)
    public void update(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validations(fillerMaterialCertificate);
        FillerMaterialCertificateEntity sentFillerMaterialCertificateEntity = new FillerMaterialCertificateEntity(fillerMaterialCertificate);
        try {
            this.fillerMaterialCertificateDal.save(sentFillerMaterialCertificateEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    @CacheEvict(cacheNames = "fillerMaterialCertificatesCache", allEntries = true)
    public void delete(int id) throws Exception {
        if (!isFillerMaterialCertificateExist(id)) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
        }
        try {
            this.fillerMaterialCertificateDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_FILLER_MATERIAL_CERTIFICATE);
        }
        try {
            FileType fileType = FileType.BASE_MATERIAL_CERTIFICATE; // Or whatever type is used to identify these files
            fileLogic.deleteByFileTypeAndResourceId(fileType, id); // Delete related files
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_FILE);
        }
    }

    public FillerMaterialCertificate getById(int id) throws Exception {
        Optional<FillerMaterialCertificateEntity> fillerMaterialCertificateEntity;
        try {
            fillerMaterialCertificateEntity = this.fillerMaterialCertificateDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_COULD_NOT_BE_FOUND);
        }
        if (fillerMaterialCertificateEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
        }
        FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntity.get());
        return fillerMaterialCertificate;
    }

    @Cacheable(cacheNames = "fillerMaterialCertificatesCache", key = "#root.methodName")
    public List<FillerMaterialCertificate> getAll() throws Exception {
        Iterable<FillerMaterialCertificateEntity> fillerMaterialCertificateEntities;
        List<FillerMaterialCertificate> fillerMaterialCertificates = new ArrayList<>();
        try {
            fillerMaterialCertificateEntities = this.fillerMaterialCertificateDal.findAll();
            // Convert Iterable to List
            for (FillerMaterialCertificateEntity fillerMaterialCertificateEntity : fillerMaterialCertificateEntities
            ) {
                FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(fillerMaterialCertificateEntity);
                fillerMaterialCertificates.add(fillerMaterialCertificate);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_COULD_NOT_BE_FOUND);
        }
        return fillerMaterialCertificates;
    }

    public List<FillerMaterialCertificate> findCertificatesByFilters(List<String> names, List<String> heatNums, List<FillerMaterialType> fillerMaterialTypes) {
        Specification<FillerMaterialCertificateEntity> spec = Specification
                .where(this.fillerMaterialCertificateSpecifications.hasNameIn(names))
                .and(this.fillerMaterialCertificateSpecifications.hasHeatNumIn(heatNums))
                .and(this.fillerMaterialCertificateSpecifications.hasFillerMaterialTypeIn(fillerMaterialTypes));

        List<FillerMaterialCertificateEntity> fillerMaterialCertificateEntities = this.fillerMaterialCertificateDal.findAll(spec);
        List<FillerMaterialCertificate> fillerMaterialCertificates = convertEntityListToDtoList(fillerMaterialCertificateEntities);

        return fillerMaterialCertificates;
    }

    private List<FillerMaterialCertificate> convertEntityListToDtoList(List<FillerMaterialCertificateEntity> fillerMaterialCertificateEntities) {
        List<FillerMaterialCertificate> fillerMaterialCertificates = new ArrayList<>();

        for (FillerMaterialCertificateEntity entity : fillerMaterialCertificateEntities
        ) {
            FillerMaterialCertificate fillerMaterialCertificate = new FillerMaterialCertificate(entity);
            fillerMaterialCertificates.add(fillerMaterialCertificate);
        }
        return fillerMaterialCertificates;
    }


    private void validations(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        validateFillerMaterialCertificateHeatNum(fillerMaterialCertificate.getHeatNum());
        validateFillerMaterialCertificateMaterialTypeName(fillerMaterialCertificate.getFillerMaterialType());
    }

    private void validateFillerMaterialCertificateMaterialTypeName(FillerMaterialType materialType) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(materialType);
    }

    private void validateFillerMaterialCertificateHeatNum(String heatNum) throws ApplicationException {
        CommonValidations.validateStringLength(heatNum, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isFillerMaterialCertificateExist(int id) {
        return this.fillerMaterialCertificateDal.existsById(id);
    }
}
