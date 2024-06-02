package com.verapipe.utils;

import com.verapipe.consts.Consts;
import com.verapipe.dto.*;
import com.verapipe.enums.ErrorType;
import com.verapipe.enums.FileExtension;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.logic.*;
import org.apache.tika.Tika;

import java.util.Base64;
import java.util.Date;
import java.util.List;

public class CommonValidations {

    private static BaseMaterialTypeLogic baseMaterialTypeLogic;
    private static FillerMaterialTypeLogic fillerMaterialTypeLogic;
    private static JointDesignLogic jointDesignLogic;
    private static FusionProcessLogic fusionProcessLogic;
    private static ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;
    private static PidLogic pidLogic;
    private static IsometricLogic isometricLogic;
    private static BaseMaterialCertificateLogic baseMaterialCertificateLogic;
    private static FillerMaterialCertificateLogic fillerMaterialCertificateLogic;

    public static void validateStringLength(String string, int min, int max) throws ApplicationException {
        if (string.length() < min) {
            throw new ApplicationException(ErrorType.TEXT_TOO_SHORT);
        }
        if (string.length() > max) {
            throw new ApplicationException(ErrorType.TEXT_TOO_LONG);
        }
    }

    public static void validateNotNegative(Float number) throws ApplicationException {
        if (number.floatValue() < 0){
            throw new ApplicationException(ErrorType.NEGATIVE_NUMBER);
        }
    }

    public static void validateIsExistInBaseMaterialTypes(String materialTypeName) throws Exception {
        List<BaseMaterialType> allBaseMaterialTypes =  baseMaterialTypeLogic.getAll();

        for (BaseMaterialType baseMaterialType : allBaseMaterialTypes){
            if (baseMaterialType.getName().equals(materialTypeName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.BASE_MATERIAL_TYPE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFillerMaterialTypes(String materialTypeName) throws Exception {
        List<FillerMaterialType> allFillerMaterialTypes =  fillerMaterialTypeLogic.getAll();

        for (FillerMaterialType fillerMaterialType : allFillerMaterialTypes){
            if (fillerMaterialType.getName().equals(materialTypeName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FILLER_MATERIAL_TYPE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInJointDesigns(String jointDesignName) throws Exception {
        List<JointDesign> allJointDesigns =  jointDesignLogic.getAll();

        for (JointDesign jointDesign : allJointDesigns){
            if (jointDesign.getName().equals(jointDesignName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.JOINT_DESIGN_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFusionProcesses(String fusionProcessName) throws Exception {
        List<FusionProcess> allFusionProcesses =  fusionProcessLogic.getAll();

        for (FusionProcess fusionProcess : allFusionProcesses){
            if (fusionProcess.getName().equals(fusionProcessName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FUSION_PROCESS_DOES_NOT_EXIST);
    }

    public static void validateIsExistInProcessSpecificationProcedures(String processSpecificationProcedureName) throws Exception {
        List<ProcessSpecificationProcedure> allProcessSpecificationProcedures =  processSpecificationProcedureLogic.getAll();

        for (ProcessSpecificationProcedure processSpecificationProcedure : allProcessSpecificationProcedures){
            if (processSpecificationProcedure.getName().equals(processSpecificationProcedureName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInPids(String pidName) throws Exception {
        List<Pid> allPids =  pidLogic.getAll();

        for (Pid pid : allPids){
            if (pid.getName().equals(pidName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.PID_DOES_NOT_EXIST);
    }

    public static void validateIsExistInIsometrics(String isometricName) throws Exception {
        List<Isometric> allIsometrics =  isometricLogic.getAll();

        for (Isometric isometric : allIsometrics){
            if (isometric.getName().equals(isometricName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.ISOMETRIC_DOES_NOT_EXIST);
    }

    public static void validateIsExistInBaseMaterialCertificates(String baseMaterialCertificateHeatNum) throws Exception {
        List<BaseMaterialCertificate> allBaseMaterialCertificates =  baseMaterialCertificateLogic.getAll();

        for (BaseMaterialCertificate baseMaterialCertificate : allBaseMaterialCertificates){
            if (baseMaterialCertificate.getHeatNum().equals(baseMaterialCertificateHeatNum)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.BASE_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
    }

    public static void validateIsExistInFillerMaterialCertificates(String fillerMaterialCertificateHeatNum) throws Exception {
        List<FillerMaterialCertificate> allFillerMaterialCertificates =  fillerMaterialCertificateLogic.getAll();

        for (FillerMaterialCertificate fillerMaterialCertificate : allFillerMaterialCertificates){
            if (fillerMaterialCertificate.getHeatNum().equals(fillerMaterialCertificateHeatNum)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.FILLER_MATERIAL_CERTIFICATE_DOES_NOT_EXIST);
    }

    public static void validateFileMaxSize(byte[] file) throws Exception {
        int fileSize = file.length;
        if (fileSize > Consts.bytesIn20MB){
            throw new ApplicationException(ErrorType.FILE_SIZE_EXCEED_MAX_SIZE);
        }
    }

    public static void validateDateIsNotLaterThanCurrentDate(Date date) throws Exception {
        Date currentDate = new Date();
        if (date.after(currentDate)){
            throw new ApplicationException(ErrorType.DATE_AND_TIME_IS_LATER_THAN_CURRENT_DATE_AND_TIME);
        }
    }

    public static void validateFileType(byte[] file, FileExtension requireFileType) throws Exception {
        String fileType = findFileType(file);
        if (!fileType.equals(requireFileType.getFileExtension())){
            throw new ApplicationException(ErrorType.FILE_EXTENSION_IS_NOT_ALLOWED);
        }
    }

    private static String findFileType(byte[] file) {
            String fileBase64Code =  Base64.getEncoder().encodeToString(file);
            String fileExtension = new Tika().detect(fileBase64Code);
            return fileExtension;
    }

//    public static void validateSetMaxSize(Set set, int maxSize) throws Exception {
//        if (set.size() == maxSize){
//            throw new ApplicationException(ErrorType.LIST_IS_FULL);
//        }
//    }
}
