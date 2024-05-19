package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IJoinerDal;
import com.verapipe.dto.Joiner;
import com.verapipe.entities.JoinerEntity;
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
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedJoinerId = joinerEntity.getId();
        return addedJoinerId;
    }

    public void update(Joiner joiner) throws Exception {
        validations(joiner);
        JoinerEntity sentJoinerEntity = new JoinerEntity(joiner);
        JoinerEntity receivedJoinerEntity;
        try {
            receivedJoinerEntity = this.joinerDal.save(sentJoinerEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentJoinerEntity.equals(receivedJoinerEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isJoinerExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.joinerDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public Joiner getById(int id) throws Exception {
        Optional<JoinerEntity> joinerEntity;
        try {
            joinerEntity = this.joinerDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (joinerEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Joiner not found");
        }
        Joiner joiner = new Joiner(joinerEntity.get());
        return joiner;
    }

    public List<Joiner> getAll() throws Exception {
        Iterable<JoinerEntity> joinerEntities = this.joinerDal.findAll();
        List<Joiner> joiners = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!joinerEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Joiners list is empty");
        }
        // Convert Iterable to List
        for (JoinerEntity joinerEntity : joinerEntities
        ) {
            Joiner joiner = new Joiner(joinerEntity);
            joiners.add(joiner);
        }
        return joiners;
    }


    private void validations(Joiner joiner) throws Exception {
        validateJoinerTagId(joiner.getTagId());
        validateJoinerCertificateFile(joiner.getCertificate());
        validateNumberInputNotNegative(joiner.getCertifiedDiameterMinMm());
        validateNumberInputNotNegative(joiner.getCertifiedDiameterMaxMm());
        validateNumberInputNotNegative(joiner.getCertifiedDiameterMinInch());
        validateNumberInputNotNegative(joiner.getCertifiedDiameterMaxInch());
        validateNumberInputNotNegative(joiner.getMaxDepositedMaterial());
        validateJoinerBaseMaterialType(joiner.getBaseMaterialTypeName1());
        validateJoinerBaseMaterialType(joiner.getBaseMaterialTypeName2());
        validateJoinerJointDesign(joiner.getJointDesignName());
        validateJoinerFusionProcess(joiner.getFusionProcessName());
    }

    private void validateJoinerCertificateFile(byte[] certificate) throws Exception {
        CommonValidations.validateFileMaxSize(certificate);
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
