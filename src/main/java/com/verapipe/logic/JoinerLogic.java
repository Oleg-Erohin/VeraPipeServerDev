package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IJoinerDal;
import com.verapipe.dto.Joiner;
import com.verapipe.entities.JoinerEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JoinerLogic {
    private IJoinerDal joinerDal;

    @Autowired
    public JoinerLogic(IJoinerDal joinerDal) {
        this.joinerDal = joinerDal;
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
        validateJoinerBaseMaterialType(joiner.getBaseMaterialTypeName1());
        if (joiner.getBaseMaterialTypeName2() != null) {
            validateJoinerBaseMaterialType(joiner.getBaseMaterialTypeName2());
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

    private void validateJoinerBaseMaterialType(String baseMaterialTypeName) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialTypeName);
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
