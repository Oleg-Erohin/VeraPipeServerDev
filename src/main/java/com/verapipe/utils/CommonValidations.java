package com.verapipe.utils;

import com.verapipe.dto.*;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.logic.*;

import java.util.List;

public class CommonValidations {

    private static BaseMaterialTypeLogic baseMaterialTypeLogic;
    private static FillerMaterialTypeLogic fillerMaterialTypeLogic;
    private static JointDesignLogic jointDesignLogic;
    private static FusionProcessLogic fusionProcessLogic;
    private static ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;
    private static PidLogic pidLogic;

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

    public static void validateIsExistInPids(String PidName) throws Exception {
        List<Pid> allPids =  pidLogic.getAll();

        for (Pid pid : allPids){
            if (pid.getName().equals(PidName)){
                return;
            }
        }

        throw new ApplicationException(ErrorType.PID_DOES_NOT_EXIST);
    }
}
