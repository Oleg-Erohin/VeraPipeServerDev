package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IJoinerDal;
import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.Joiner;
import com.verapipe.entities.*;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.JoinerSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JoinerLogic {
    private IJoinerDal joinerDal;
    private JoinerSpecifications joinerSpecifications;

    @Autowired
    public JoinerLogic(IJoinerDal joinerDal, JoinerSpecifications joinerSpecifications) {
        this.joinerDal = joinerDal;
        this.joinerSpecifications = joinerSpecifications;
    }

    public int add(Joiner joiner) throws Exception {
        validations(joiner);
        JoinerEntity joinerEntity = new JoinerEntity(joiner);
        try {
            joinerEntity = this.joinerDal.save(joinerEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINER_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedJoinerId = joinerEntity.getId();
        return addedJoinerId;
    }

    public void update(Joiner joiner) throws Exception {
        validations(joiner);
        JoinerEntity sentJoinerEntity = new JoinerEntity(joiner);
        try {
            this.joinerDal.save(sentJoinerEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINER_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isJoinerExist(id)) {
            throw new ApplicationException(ErrorType.JOINER_DOES_NOT_EXIST);
        }
        try {
            this.joinerDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_JOINER);
        }
    }

    public Joiner getById(int id) throws Exception {
        Optional<JoinerEntity> joinerEntity;
        try {
            joinerEntity = this.joinerDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINER_COULD_NOT_BE_FOUND);
        }
        if (joinerEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.JOINER_DOES_NOT_EXIST);
        }
        Joiner joiner = new Joiner(joinerEntity.get());
        return joiner;
    }

    public List<Joiner> getAll() throws Exception {
        Iterable<JoinerEntity> joinerEntities;
        List<Joiner> joiners = new ArrayList<>();
        try {
            joinerEntities = this.joinerDal.findAll();
            // Convert Iterable to List
            for (JoinerEntity joinerEntity : joinerEntities
            ) {
                Joiner joiner = new Joiner(joinerEntity);
                joiners.add(joiner);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINER_COULD_NOT_BE_FOUND);
        }

        return joiners;
    }

    public List<Joiner> findJoinersByFilters(Set<String> tagIds, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, Set<BaseMaterialTypeEntity> baseMaterialTypes, JointDesignEntity jointDesign, FusionProcessEntity fusionProcess, Set<JointEntity> joints) {
        Specification<JoinerEntity> spec = Specification
                .where(joinerSpecifications.hasTagIdIn(tagIds))
                .and(joinerSpecifications.hasCertifiedDiameterMinMm(certifiedDiameterMinMm))
                .and(joinerSpecifications.hasCertifiedDiameterMaxMm(certifiedDiameterMaxMm))
                .and(joinerSpecifications.hasCertifiedDiameterMinInch(certifiedDiameterMinInch))
                .and(joinerSpecifications.hasCertifiedDiameterMaxInch(certifiedDiameterMaxInch))
                .and(joinerSpecifications.hasMaxDepositedMaterial(maxDepositedMaterial))
                .and(joinerSpecifications.hasBaseMaterialTypesIn(baseMaterialTypes))
                .and(joinerSpecifications.hasJointDesign(jointDesign))
                .and(joinerSpecifications.hasFusionProcess(fusionProcess))
                .and(joinerSpecifications.hasJointsIn(joints));
        List<JoinerEntity> joinerEntities = this.joinerDal.findAll(spec);
        List<Joiner> joiners = convertEntityListToDtoList(joinerEntities);
        return joiners;
    }

    private List<Joiner> convertEntityListToDtoList(List<JoinerEntity> joinerEntities) {
        List<Joiner> joiners = new ArrayList<>();
        for (JoinerEntity entity : joinerEntities
             ) {
            Joiner joiner = new Joiner(entity);
            joiners.add(joiner);
        }
        return joiners;
    }


    private void validations(Joiner joiner) throws Exception {
        validateJoinerTagId(joiner.getTagId());
        if (joiner.getCertifiedDiameterMinMm() != null) {
            validateNumberInputNotNegative(joiner.getCertifiedDiameterMinMm());
        }
        if (joiner.getCertifiedDiameterMaxMm() != null) {
            validateNumberInputNotNegative(joiner.getCertifiedDiameterMaxMm());
        }
        if (joiner.getCertifiedDiameterMinInch() != null) {
            validateNumberInputNotNegative(joiner.getCertifiedDiameterMinInch());
        }
        if (joiner.getCertifiedDiameterMaxInch() != null) {
            validateNumberInputNotNegative(joiner.getCertifiedDiameterMaxInch());
        }
        validateNumberInputNotNegative(joiner.getMaxDepositedMaterial());
        validateJoinerBaseMaterialType(joiner.getBaseMaterialType1());
        if (joiner.getBaseMaterialType2() != null) {
            validateJoinerBaseMaterialType(joiner.getBaseMaterialType2());
        }
        validateJoinerJointDesign(joiner.getJointDesignName());
        validateJoinerFusionProcess(joiner.getFusionProcessName());
    }

    private void validateJoinerFusionProcess(String fusionProcessName) throws Exception {
        CommonValidations.validateIsExistInFusionProcesses(fusionProcessName);
    }

    private void validateJoinerJointDesign(String jointDesignName) throws Exception {
        CommonValidations.validateIsExistInJointDesigns(jointDesignName);
    }

    private void validateJoinerBaseMaterialType(BaseMaterialType baseMaterialType) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialType);
    }

    private void validateNumberInputNotNegative(Float number) throws ApplicationException {
        CommonValidations.validateNotNegative(number);
    }

    private void validateJoinerTagId(String tagId) throws ApplicationException {
        CommonValidations.validateStringLength(tagId, Consts.joinerTagIdLengthMin, Consts.joinerTagIdLengthMax);
    }

    private boolean isJoinerExist(int id) {
        return this.joinerDal.existsById(id);
    }
}
