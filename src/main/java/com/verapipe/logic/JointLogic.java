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
        validateJointPid(joint.getPid());
        validateJointIsometric(joint.getIsometric());
        if (joint.getUom() == UnitOfMeasure.MM) {
            joint.setSchedule(null);
        }
        validateDiameter(joint.getDiameter());
        validateJointFittingDescription(joint.getFittingDescription1());
        validateJointBaseMaterialType(joint.getBaseMaterialType1());
        if (joint.getBaseMaterial1() != null) {
            validateJointBaseMaterialHeatNum(joint.getBaseMaterial1());
        }
        validateJointFittingDescription(joint.getFittingDescription2());
        if (joint.getBaseMaterialType2() != null) {
            validateJointBaseMaterialType(joint.getBaseMaterialType2());
            if (joint.getBaseMaterial2() != null) {
                validateJointBaseMaterialHeatNum(joint.getBaseMaterial2());
            }
        }
//        validateThickness(joint);
        if (joint.getFillerMaterialType1() != null) {
            validateJointFillerMaterialType(joint.getFillerMaterialType1());
            if (joint.getFillerMaterial1() != null) {
                validateJointFillerMaterialHeatNum(joint.getFillerMaterial1());
            }
            if (joint.getFillerMaterialType2() != null) {
                validateJointFillerMaterialType(joint.getFillerMaterialType2());
                if (joint.getFillerMaterial2() != null) {
                    validateJointFillerMaterialHeatNum(joint.getFillerMaterial2());
                }
            }
        }

        if (joint.getProcessSpecificationProcedure() != null) {
            validateJointProcessSpecificationProcedure(joint.getProcessSpecificationProcedure());
        }
        if (joint.getJoiner1() != null) {
            validateJointJoinerTagId(joint.getJoiner1());
            if (joint.getJoiner2() != null) {
                validateJointJoinerTagId(joint.getJoiner2());
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
        if (joint.getNdtReport() != null) {
            validateJointNdtReport(joint.getNdtReport());
        }
        if (joint.isNdtPassed()) {
//        validateJointIsNdtPassed(joint.isNdtPassed());
        }
        if (joint.getPreheat() != null) {
            validateJointPreHeat(joint.getPreheat());
        }
        if (joint.getPostWeldHeatTreatment() != null) {
            validateJointPostWeldHeatTreatment(joint.getPostWeldHeatTreatment());
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

    private void validateJointDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validateJointJoinerTagId(Joiner joiner) throws Exception {
        List<Joiner> allJoiners = this.joinerLogic.getAll();
        for (Joiner currentJoiner : allJoiners) {
            if (currentJoiner.equals(joiner)) {
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

    private void validateJointPostWeldHeatTreatment(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        List<PostWeldHeatTreatment> postWeldHeatTreatments = postWeldHeatTreatmentLogic.getAll();

        for (PostWeldHeatTreatment currentPostWeldHeatTreatment : postWeldHeatTreatments) {
            if (currentPostWeldHeatTreatment.equals(postWeldHeatTreatment)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_DOES_NOT_EXIST);
    }

    private void validateJointPreHeat(Preheat preheat) throws Exception {
        List<Preheat> preheats = preheatLogic.getAll();

        for (Preheat currentPreheat : preheats) {
            if (currentPreheat.equals(preheat)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.PREHEAT_DOES_NOT_EXIST);
    }

    private void validateJointNdtReport(NdtReport ndtReport) throws Exception {
        List<NdtReport> ndtReports = ndtReportLogic.getAll();

        for (NdtReport currentNdtReport : ndtReports) {
            if (currentNdtReport.equals(ndtReport)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.NDT_REPORT_DOES_NOT_EXIST);
    }

    private void validateJointFillerMaterialHeatNum(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialCertificates(fillerMaterialCertificate);
    }

    private void validateJointBaseMaterialHeatNum(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialCertificates(baseMaterialCertificate);
    }

    private void validateJointIsometric(Isometric isometric) throws Exception {
        CommonValidations.validateIsExistInIsometrics(isometric);
    }

    private void validateJointProcessSpecificationProcedure(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        CommonValidations.validateIsExistInProcessSpecificationProcedures(processSpecificationProcedure);
    }

    private void validateJointPid(Pid pid) throws Exception {
        CommonValidations.validateIsExistInPids(pid);
    }

    private void validateJointFillerMaterialType(FillerMaterialType fillerMaterialType) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(fillerMaterialType);
    }

    private void validateJointBaseMaterialType(BaseMaterialType baseMaterialType) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialType);
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
