package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IJointDal;
import com.verapipe.dto.Joint;
import com.verapipe.entities.JointEntity;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JointLogic {
    private IJointDal jointDal;

    @Autowired
    public JointLogic(IJointDal jointDal) {
        this.jointDal = jointDal;
    }

    public int add(Joint joint) throws Exception {
        validations(joint);
        JointEntity jointEntity = new JointEntity(joint);
        try {
            jointEntity = this.jointDal.save(jointEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedJointId = jointEntity.getId();
        return addedJointId;
    }

    public void update(Joint joint) throws Exception {
        validations(joint);
        JointEntity sentJointEntity = new JointEntity(joint);
        JointEntity receivedJointEntity;
        try {
            receivedJointEntity = this.jointDal.save(sentJointEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentJointEntity.equals(receivedJointEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isJointExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.jointDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public Joint getById(int id) throws Exception {
        Optional<JointEntity> jointEntity;
        try {
            jointEntity = this.jointDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (jointEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Joint not found");
        }
        Joint joint = new Joint(jointEntity.get());
        return joint;
    }

    public List<Joint> getAll() throws Exception {
        Iterable<JointEntity> jointEntities = this.jointDal.findAll();
        List<Joint> joints = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!jointEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Joints list is empty");
        }
        // Convert Iterable to List
        for (JointEntity jointEntity : jointEntities
        ) {
            Joint joint = new Joint(jointEntity);
            joints.add(joint);
        }
        return joints;
    }


    private void validations(Joint joint) throws Exception {
//        validateJointNumber(joint.getNumber());
//        validateJointCoordinatesOnIsometric(joint.getCoordinatesOnIsometric());
        validateJointPid(joint.getPidName());
//        validateJointIsometric(joint.getIsometricName());
//        validateJointSheetOnIsometric(joint.getSheetOnIsometric());
        validateNumberInputNotNegative(joint.getDiameterMm());
        validateNumberInputNotNegative(joint.getDiameterInch());
        validateJointFittingDescription(joint.getFittingDescription1());
        validateJointBaseMaterialType(joint.getBaseMaterialTypeName1());
//        validateJointBaseMaterialHeatNum1(joint.getBaseMaterialHeatNum1());
        validateJointFittingDescription(joint.getFittingDescription2());
        validateJointBaseMaterialType(joint.getBaseMaterialTypeName2());
//        validateJointBaseMaterialHeatNum2(joint.getBaseMaterialHeatNum2());
        validateJointFillerMaterialType(joint.getFillerMaterialTypeName1());
//        validateJointFillerMaterialHeatNum1(joint.getFillerMaterialHeatNum1());
        validateJointFillerMaterialType(joint.getFillerMaterialTypeName2());
//        validateJointFillerMaterialHeatNum2(joint.getFillerMaterialHeatNum2());
        validateJointProcessSpecificationProcedure(joint.getProcessSpecificationProcedureName());
//        validateJointJoinerTagIds(joint.getJoinersTagIdList());
//        validateJointDate(joint.getDate());
//        validateJointIsFitUpDone(joint.isFitUpDone());
//        validateJointIsVisualInspectionDone(joint.isVisualInspectionDone());
//        validateJointNdtReport(joint.getNdtReportName());
//        validateJointIsNdtPassed(joint.isNdtPassed());
//        validateJointPreHeat(joint.getPreheatName());
//        validateJointPostWeldHeatTreatment(joint.getPostWeldHeatTreatmentName());
//        validateJointComments(joint.getComments());
    }

    private void validateJointProcessSpecificationProcedure(String processSpecificationProcedureName) throws Exception {
        CommonValidations.validateIsExistInProcessSpecificationProcedures(processSpecificationProcedureName);
    }

    private void validateJointPid(String pidName) throws Exception {
        CommonValidations.validateIsExistInPids(pidName);
    }

    private void validateJointFillerMaterialType(String fillerMaterialTypeName) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(fillerMaterialTypeName);
    }

    private void validateJointBaseMaterialType(String baseMaterialTypeName) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialTypeName);
    }

    private void validateNumberInputNotNegative(Float number) throws ApplicationException {
        CommonValidations.validateNotNegative(number);
    }

    private void validateJointFittingDescription(String fittingDescription) throws ApplicationException {
        CommonValidations.validateStringLength(fittingDescription, Consts.fittingDescriptionLengthMin, Consts.fittingDescriptionLengthMax);
    }

    private boolean isJointExist(int id) {
        return this.jointDal.existsById(id);
    }
}
