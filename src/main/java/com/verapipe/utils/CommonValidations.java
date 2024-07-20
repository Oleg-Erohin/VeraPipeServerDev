package com.verapipe.utils;

import com.verapipe.dto.*;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class CommonValidations {

    private final BaseMaterialTypeLogic baseMaterialTypeLogic;
    private final FillerMaterialTypeLogic fillerMaterialTypeLogic;
    private final JointDesignLogic jointDesignLogic;
    private final FusionProcessLogic fusionProcessLogic;
    private final ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;
    private final PidLogic pidLogic;
    private final IsometricLogic isometricLogic;
    private final BaseMaterialCertificateLogic baseMaterialCertificateLogic;
    private final FillerMaterialCertificateLogic fillerMaterialCertificateLogic;

    @Autowired
    public CommonValidations(
            BaseMaterialTypeLogic baseMaterialTypeLogic,
            FillerMaterialTypeLogic fillerMaterialTypeLogic,
            JointDesignLogic jointDesignLogic,
            FusionProcessLogic fusionProcessLogic,
            ProcessSpecificationProcedureLogic processSpecificationProcedureLogic,
            PidLogic pidLogic,
            IsometricLogic isometricLogic,
            BaseMaterialCertificateLogic baseMaterialCertificateLogic,
            FillerMaterialCertificateLogic fillerMaterialCertificateLogic) {
        this.baseMaterialTypeLogic = baseMaterialTypeLogic;
        this.fillerMaterialTypeLogic = fillerMaterialTypeLogic;
        this.jointDesignLogic = jointDesignLogic;
        this.fusionProcessLogic = fusionProcessLogic;
        this.processSpecificationProcedureLogic = processSpecificationProcedureLogic;
        this.pidLogic = pidLogic;
        this.isometricLogic = isometricLogic;
        this.baseMaterialCertificateLogic = baseMaterialCertificateLogic;
        this.fillerMaterialCertificateLogic = fillerMaterialCertificateLogic;
    }

    private static class Holder {
        private static BaseMaterialTypeLogic baseMaterialTypeLogic;
        private static FillerMaterialTypeLogic fillerMaterialTypeLogic;
        private static JointDesignLogic jointDesignLogic;
        private static FusionProcessLogic fusionProcessLogic;
        private static ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;
        private static PidLogic pidLogic;
        private static IsometricLogic isometricLogic;
        private static BaseMaterialCertificateLogic baseMaterialCertificateLogic;
        private static FillerMaterialCertificateLogic fillerMaterialCertificateLogic;
    }

    @PostConstruct
    private void initializeHolder() {
        Holder.baseMaterialTypeLogic = this.baseMaterialTypeLogic;
        Holder.fillerMaterialTypeLogic = this.fillerMaterialTypeLogic;
        Holder.jointDesignLogic = this.jointDesignLogic;
        Holder.fusionProcessLogic = this.fusionProcessLogic;
        Holder.processSpecificationProcedureLogic = this.processSpecificationProcedureLogic;
        Holder.pidLogic = this.pidLogic;
        Holder.isometricLogic = this.isometricLogic;
        Holder.baseMaterialCertificateLogic = this.baseMaterialCertificateLogic;
        Holder.fillerMaterialCertificateLogic = this.fillerMaterialCertificateLogic;
    }

    public static void validateStringLength(String string, int min, int max) throws ApplicationException {
        if (string.length() < min) {
            throw new ApplicationException(ErrorType.TEXT_TOO_SHORT);
        }
        if (string.length() > max) {
            throw new ApplicationException(ErrorType.TEXT_TOO_LONG);
        }
    }

    public static void validateNotNegative(Float number) throws ApplicationException {
        if (number < 0){
            throw new ApplicationException(ErrorType.NEGATIVE_NUMBER);
        }
    }

    public static void validateIsExistInBaseMaterialTypes(BaseMaterialType baseMaterialType) throws Exception {
        List<BaseMaterialType> allBaseMaterialTypes =  Holder.baseMaterialTypeLogic.getAll();

        for (BaseMaterialType currentBaseMaterialType : allBaseMaterialTypes){
            if (currentBaseMaterialType.equals(baseMaterialType)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFillerMaterialTypes(FillerMaterialType fillerMaterialType) throws Exception {
        List<FillerMaterialType> allFillerMaterialTypes =  Holder.fillerMaterialTypeLogic.getAll();

        for (FillerMaterialType currentFillerMaterialType : allFillerMaterialTypes){
            if (currentFillerMaterialType.equals(fillerMaterialType)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInJointDesigns(JointDesign jointDesign) throws Exception {
        List<JointDesign> allJointDesigns =  Holder.jointDesignLogic.getAll();

        for (JointDesign currentJointDesign : allJointDesigns){
            if (currentJointDesign.equals(jointDesign)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.JOINT_DESIGN_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFusionProcesses(FusionProcess fusionProcess) throws Exception {
        List<FusionProcess> allFusionProcesses =  Holder.fusionProcessLogic.getAll();

        for (FusionProcess currentFusionProcess : allFusionProcesses){
            if (currentFusionProcess.equals(fusionProcess)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FUSION_PROCESS_DOES_NOT_EXIST);
    }

    public static void validateIsExistInProcessSpecificationProcedures(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        List<ProcessSpecificationProcedure> allProcessSpecificationProcedures =  Holder.processSpecificationProcedureLogic.getAll();

        for (ProcessSpecificationProcedure currentProcessSpecificationProcedure : allProcessSpecificationProcedures){
            if (currentProcessSpecificationProcedure.getName().equals(processSpecificationProcedure)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInPids(Pid pid) throws Exception {
        List<Pid> allPids =  Holder.pidLogic.getAll();

        for (Pid currentPid : allPids){
            if (currentPid.equals(pid)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.PID_DOES_NOT_EXIST);
    }

    public static void validateIsExistInIsometrics(Isometric isometric) throws Exception {
        List<Isometric> allIsometrics =  Holder.isometricLogic.getAll();

        for (Isometric currentIsometric : allIsometrics){
            if (currentIsometric.equals(isometric)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.ISOMETRIC_DOES_NOT_EXIST);
    }

    public static void validateIsExistInBaseMaterialCertificates(BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        List<BaseMaterialCertificate> allBaseMaterialCertificates =  Holder.baseMaterialCertificateLogic.getAll();

        for (BaseMaterialCertificate currentBaseMaterialCertificate : allBaseMaterialCertificates){
            if (currentBaseMaterialCertificate.equals(baseMaterialCertificate)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFillerMaterialCertificates(FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        List<FillerMaterialCertificate> allFillerMaterialCertificates =  Holder.fillerMaterialCertificateLogic.getAll();

        for (FillerMaterialCertificate currentFillerMaterialCertificate : allFillerMaterialCertificates){
            if (currentFillerMaterialCertificate.equals(fillerMaterialCertificate)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
    }

    public static void validateDateIsNotLaterThanCurrentDate(Date date) throws Exception {
        Date currentDate = new Date();
        if (date.after(currentDate)){
            throw new ApplicationException(ErrorType.DATE_AND_TIME_IS_LATER_THAN_CURRENT_DATE_AND_TIME);
        }
    }
}
