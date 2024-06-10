package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IJointDesignDal;
import com.verapipe.dto.JointDesign;
import com.verapipe.entities.JointDesignEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JointDesignLogic {
    private IJointDesignDal jointDesignDal;

    @Autowired
    public JointDesignLogic(IJointDesignDal jointDesignDal) {
        this.jointDesignDal = jointDesignDal;
    }

    public int add(JointDesign jointDesign) throws Exception {
        validations(jointDesign);
        JointDesignEntity jointDesignEntity = new JointDesignEntity(jointDesign);
        try {
            jointDesignEntity = this.jointDesignDal.save(jointDesignEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedJointDesignId = jointDesignEntity.getId();
        return addedJointDesignId;
    }

    public void update(JointDesign jointDesign) throws Exception {
        validations(jointDesign);
        JointDesignEntity sentJointDesignEntity = new JointDesignEntity(jointDesign);
        try {
            this.jointDesignDal.save(sentJointDesignEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isJointDesignExist(id)) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_DOES_NOT_EXIST);
        }
        try {
            this.jointDesignDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_JOINT_DESIGN);
        }
    }

    public JointDesign getById(int id) throws Exception {
        Optional<JointDesignEntity> jointDesignEntity;
        try {
            jointDesignEntity = this.jointDesignDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_COULD_NOT_BE_FOUND);
        }
        if (jointDesignEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_DOES_NOT_EXIST);
        }
        JointDesign jointDesign = new JointDesign(jointDesignEntity.get());
        return jointDesign;
    }

    @Cacheable(cacheNames = "jointDesignsCache", key = "#root.methodName")
    public List<JointDesign> getAll() throws Exception {
        Iterable<JointDesignEntity> jointDesignEntities;
        List<JointDesign> jointDesigns = new ArrayList<>();
        try{
            jointDesignEntities = this.jointDesignDal.findAll();
            // Convert Iterable to List
            for (JointDesignEntity jointDesignEntity : jointDesignEntities
            ) {
                JointDesign jointDesign = new JointDesign(jointDesignEntity);
                jointDesigns.add(jointDesign);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_DESIGN_COULD_NOT_BE_FOUND);
        }
        return jointDesigns;
    }


    private void validations(JointDesign jointDesign) throws Exception {
        validateJointDesignName(jointDesign.getName());
    }

    private void validateJointDesignName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isJointDesignExist(int id) {
        return this.jointDesignDal.existsById(id);
    }
}
