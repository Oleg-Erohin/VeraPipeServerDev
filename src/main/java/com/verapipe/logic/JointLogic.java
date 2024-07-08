package com.verapipe.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.consts.Consts;
import com.verapipe.dal.IJointDal;
import com.verapipe.dto.*;
import com.verapipe.entities.*;
import com.verapipe.enums.ErrorType;
import com.verapipe.enums.UnitOfMeasure;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.JointSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JointLogic {
    private IJointDal jointDal;
    private NdtReportLogic ndtReportLogic;
    private PreheatLogic preheatLogic;
    private PostWeldHeatTreatmentLogic postWeldHeatTreatmentLogic;
    private JoinerLogic joinerLogic;
    private IsometricLogic isometricLogic;
    private ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;
    private JointSpecifications jointSpecifications;

    @Autowired
    public JointLogic(IJointDal jointDal,
                      NdtReportLogic ndtReportLogic,
                      PreheatLogic preheatLogic,
                      PostWeldHeatTreatmentLogic postWeldHeatTreatmentLogic,
                      JoinerLogic joinerLogic,
                      IsometricLogic isometricLogic,
                      ProcessSpecificationProcedureLogic processSpecificationProcedureLogic,
                      JointSpecifications jointSpecifications
                      ) {
        this.jointDal = jointDal;
        this.ndtReportLogic = ndtReportLogic;
        this.preheatLogic = preheatLogic;
        this.postWeldHeatTreatmentLogic = postWeldHeatTreatmentLogic;
        this.joinerLogic = joinerLogic;
        this.isometricLogic = isometricLogic;
        this.processSpecificationProcedureLogic = processSpecificationProcedureLogic;
        this.jointSpecifications = jointSpecifications;
    }

    public int add(Joint joint) throws Exception {
        validations(joint);
        JointEntity jointEntity = new JointEntity(joint);
        try {
            jointEntity = this.jointDal.save(jointEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedJointId = jointEntity.getId();
        return addedJointId;
    }

    public void update(Joint joint) throws Exception {
        validations(joint);
        JointEntity sentJointEntity = new JointEntity(joint);
        try {
            this.jointDal.save(sentJointEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isJointExist(id)) {
            throw new ApplicationException(ErrorType.JOINT_COULD_NOT_BE_FOUND);
        }
        try {
            this.jointDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_JOINT);
        }
    }

    public Joint getById(int id) throws Exception {
        Optional<JointEntity> jointEntity;
        try {
            jointEntity = this.jointDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_COULD_NOT_BE_FOUND);
        }
        if (jointEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.JOINT_DOES_NOT_EXIST);
        }
        Joint joint = new Joint(jointEntity.get());
        return joint;
    }

    public List<Joint> getAll() throws Exception {
        Iterable<JointEntity> jointEntities;
        List<Joint> joints = new ArrayList<>();
        try {
            jointEntities = this.jointDal.findAll();
            // Convert Iterable to List
            for (JointEntity jointEntity : jointEntities
            ) {
                Joint joint = new Joint(jointEntity);
                joints.add(joint);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.JOINT_COULD_NOT_BE_FOUND);
        }
        return joints;
    }

    public List<Joint> findJointsByFilters(Integer number, String coordinatesOnIsometric, PidEntity pid, IsometricEntity isometric, Integer sheetOnIsometric, UnitOfMeasure uom, String schedule, Float diameter, String fittingDescription1, String comments, String fittingDescription2, Set<BaseMaterialTypeEntity> baseMaterialTypeList, Set<BaseMaterialCertificateEntity> baseMaterialCertificateList, Float thickness, Set<FillerMaterialTypeEntity> fillerMaterialTypeList, Set<FillerMaterialCertificateEntity> fillerMaterialCertificateList, ProcessSpecificationProcedureEntity processSpecificationProcedure, Set<JoinerEntity> joinersList, Date date, Boolean isFitUpDone, Boolean isVisualInspectionDone, NdtReportEntity ndtReport, Boolean isNdtPassed, PreheatEntity preheat, PostWeldHeatTreatmentEntity postWeldHeatTreatment) throws JsonProcessingException {
        Specification<JointEntity> spec = Specification
                .where(jointSpecifications.hasNumber(number))
                .and(jointSpecifications.hasCoordinatesOnIsometric(coordinatesOnIsometric))
                .and(jointSpecifications.hasPid(pid))
                .and(jointSpecifications.hasIsometric(isometric))
                .and(jointSpecifications.hasSheetOnIsometric(sheetOnIsometric))
                .and(jointSpecifications.hasUom(uom))
                .and(jointSpecifications.hasSchedule(schedule))
                .and(jointSpecifications.hasDiameter(diameter))
                .and(jointSpecifications.hasFittingDescription1(fittingDescription1))
                .and(jointSpecifications.hasComments(comments))
                .and(jointSpecifications.hasFittingDescription2(fittingDescription2))
                .and(jointSpecifications.hasBaseMaterialTypesIn(baseMaterialTypeList))
                .and(jointSpecifications.hasBaseMaterialCertificatesIn(baseMaterialCertificateList))
                .and(jointSpecifications.hasThickness(thickness))
                .and(jointSpecifications.hasFillerMaterialTypesIn(fillerMaterialTypeList))
                .and(jointSpecifications.hasFillerMaterialCertificatesIn(fillerMaterialCertificateList))
                .and(jointSpecifications.hasProcessSpecificationProcedure(processSpecificationProcedure))
                .and(jointSpecifications.hasJoinersIn(joinersList))
                .and(jointSpecifications.hasDate(date))
                .and(jointSpecifications.isFitUpDone(isFitUpDone))
                .and(jointSpecifications.isVisualInspectionDone(isVisualInspectionDone))
                .and(jointSpecifications.hasNdtReport(ndtReport))
                .and(jointSpecifications.isNdtPassed(isNdtPassed))
                .and(jointSpecifications.hasPreheat(preheat))
                .and(jointSpecifications.hasPostWeldHeatTreatment(postWeldHeatTreatment));
        List<JointEntity> jointEntities = this.jointDal.findAll(spec);
        List<Joint>joints = convertEntityListToDtoList(jointEntities);
        return joints;
    }

    private List<Joint> convertEntityListToDtoList(List<JointEntity> jointEntities) throws JsonProcessingException {
        List<Joint>joints = new ArrayList<>();
        for (JointEntity entity : jointEntities
             ) {
            Joint joint = new Joint(entity);
            joints.add(joint);
        }
        return joints;
    }


    private void validations(Joint joint) throws Exception {
//        validateJointNumber(joint.getNumber());
//        validateJointCoordinatesOnIsometric(joint.getCoordinatesOnIsometric());
        validateJointPid(joint.getPidName());
        validateJointIsometric(joint.getIsometricName());
        validateJointSheetOnIsometric(joint.getIsometricName(), joint.getSheetOnIsometric());
        if (joint.getUom() == UnitOfMeasure.MM) {
            joint.setSchedule(null);
        }
        validateDiameter(joint.getDiameter());
        validateJointFittingDescription(joint.getFittingDescription1());
        validateJointBaseMaterialType(joint.getBaseMaterialTypeName1());
        if (joint.getBaseMaterialHeatNum1() != null) {
            validateJointBaseMaterialHeatNum(joint.getBaseMaterialHeatNum1());
        }
        validateJointFittingDescription(joint.getFittingDescription2());
        if (joint.getBaseMaterialTypeName2() != null) {
            validateJointBaseMaterialType(joint.getBaseMaterialTypeName2());
            if (joint.getBaseMaterialHeatNum2() != null) {
                validateJointBaseMaterialHeatNum(joint.getBaseMaterialHeatNum2());
            }
        }
//        validateThickness(joint);
        if (joint.getFillerMaterialTypeName1() != null) {
            validateJointFillerMaterialType(joint.getFillerMaterialTypeName1());
            if (joint.getFillerMaterialHeatNum1() != null) {
                validateJointFillerMaterialHeatNum(joint.getFillerMaterialHeatNum1());
            }
        }
        if (joint.getFillerMaterialTypeName2() != null) {
            validateJointFillerMaterialType(joint.getFillerMaterialTypeName2());
            if (joint.getFillerMaterialHeatNum2() != null) {
                validateJointFillerMaterialHeatNum(joint.getFillerMaterialHeatNum2());
            }
        }
        if (joint.getProcessSpecificationProcedureName() != null) {
            validateJointProcessSpecificationProcedure(joint.getProcessSpecificationProcedureName());
        }
        if (joint.getJoinerTagId1() != null) {
            validateJointJoinerTagId(joint.getJoinerTagId1());
            if (joint.getJoinerTagId2() != null) {
                validateJointJoinerTagId(joint.getJoinerTagId2());
            }
        }
        if (joint.getDate() != null) {
            validateJointDate(joint.getDate());
        }
        if (joint.isFitUpDone()) {
//        validateJointIsFitUpDone(joint.isFitUpDone());
        }
        if (joint.isVisualInspectionDone()) {
//        validateJointIsVisualInspectionDone(joint.isVisualInspectionDone());
        }
        if (joint.getNdtReportName() != null) {
            validateJointNdtReport(joint.getNdtReportName());
        }
        if (joint.isNdtPassed()) {
//        validateJointIsNdtPassed(joint.isNdtPassed());
        }
        if (joint.getPreheatName() != null) {
            validateJointPreHeat(joint.getPreheatName());
        }
        if (joint.getPostWeldHeatTreatmentName() != null) {
            validateJointPostWeldHeatTreatment(joint.getPostWeldHeatTreatmentName());
        }
        if (joint.getComments() != null) {
//        validateJointComments(joint.getComments());
        }
    }

    private void validateDiameter(Float diameter) throws ApplicationException {
        CommonValidations.validateNotNegative(diameter);
    }

//    private void validateThickness(Joint joint) {
//        ProcessSpecificationProcedure psp = this.processSpecificationProcedureLogic.getByName(joint.getProcessSpecificationProcedureName());
//        ThicknessUOM thicknessUOM = psp.getThicknessUom();
//        if (thicknessUOM == ThicknessUOM.SCH){
//
//        } else {
//
//        }
//    }

    private void validateJointSheetOnIsometric(String isometricName, int sheetOnIsometric) throws Exception {
        List<Isometric> allIsometrics = isometricLogic.getAll();
        Isometric isometric = null;

        while (isometric == null) {
            for (Isometric currentIsometric : allIsometrics) {
                if (currentIsometric.getName().equals(isometricName)) {
                    isometric = currentIsometric;
                }
            }
        }

        if (isometric.getSheets() < 0 || isometric.getSheets() > sheetOnIsometric) {
            //          TODO throw new ApplicationException
            throw new Exception("Sheet number does not match the sheets of the isometric");
        }
    }

    private void validateJointDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validateJointJoinerTagId(String joinersTagId) throws Exception {
        List<Joiner> allJoiners = this.joinerLogic.getAll();
        for (Joiner joiner : allJoiners) {
            if (joiner.getTagId().equals(joinersTagId)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.JOINER_DOES_NOT_EXIST);
    }

    private void validateIsExistInJoinerTagIds(String joinerTagId) throws Exception {
        List<Joiner> joiners = joinerLogic.getAll();

        for (Joiner joiner : joiners) {
            if (joiner.getTagId().equals(joinerTagId)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.JOINER_DOES_NOT_EXIST);
    }

    private void validateJointPostWeldHeatTreatment(String postWeldHeatTreatmentName) throws Exception {
        List<PostWeldHeatTreatment> postWeldHeatTreatments = postWeldHeatTreatmentLogic.getAll();

        for (PostWeldHeatTreatment postWeldHeatTreatment : postWeldHeatTreatments) {
            if (postWeldHeatTreatment.getName().equals(postWeldHeatTreatmentName)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_DOES_NOT_EXIST);
    }

    private void validateJointPreHeat(String preheatName) throws Exception {
        List<Preheat> preheats = preheatLogic.getAll();

        for (Preheat preheat : preheats) {
            if (preheat.getName().equals(preheatName)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.PREHEAT_DOES_NOT_EXIST);
    }

    private void validateJointNdtReport(String ndtReportName) throws Exception {
        List<NdtReport> ndtReports = ndtReportLogic.getAll();

        for (NdtReport ndtReport : ndtReports) {
            if (ndtReport.getName().equals(ndtReportName)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.NDT_REPORT_DOES_NOT_EXIST);
    }

    private void validateJointFillerMaterialHeatNum(String fillerMaterialHeatNum) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialCertificates(fillerMaterialHeatNum);
    }

    private void validateJointBaseMaterialHeatNum(String baseMaterialHeatNum) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialCertificates(baseMaterialHeatNum);
    }

    private void validateJointIsometric(String isometricName) throws Exception {
        CommonValidations.validateIsExistInIsometrics(isometricName);
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
