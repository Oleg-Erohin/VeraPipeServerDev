package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IProcessSpecificationProcedureDal;
import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.dto.StandardCode;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
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
public class ProcessSpecificationProcedureLogic {
    private IProcessSpecificationProcedureDal processSpecificationProcedureDal;
    private StandardCodeLogic standardCodeLogic;

    @Autowired
    public ProcessSpecificationProcedureLogic(IProcessSpecificationProcedureDal processSpecificationProcedureDal, StandardCodeLogic standardCodeLogic) {
        this.processSpecificationProcedureDal = processSpecificationProcedureDal;
        this.standardCodeLogic = standardCodeLogic;
    }

    public int add(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity processSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.save(processSpecificationProcedureEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedProcessSpecificationProcedureId = processSpecificationProcedureEntity.getId();
        return addedProcessSpecificationProcedureId;
    }

    public void update(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity sentProcessSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity receivedProcessSpecificationProcedureEntity;
        try {
            receivedProcessSpecificationProcedureEntity = this.processSpecificationProcedureDal.save(sentProcessSpecificationProcedureEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentProcessSpecificationProcedureEntity.equals(receivedProcessSpecificationProcedureEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isProcessSpecificationProcedureExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.processSpecificationProcedureDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public ProcessSpecificationProcedure getById(int id) throws Exception {
        Optional<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntity;
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (processSpecificationProcedureEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Process Specification Procedure not found");
        }
        ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity.get());
        return processSpecificationProcedure;
    }

    @Cacheable(cacheNames = "processSpecificationProceduresCache", key = "#root.methodName")
    public List<ProcessSpecificationProcedure> getAll() throws Exception {
        Iterable<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntities = this.processSpecificationProcedureDal.findAll();
        List<ProcessSpecificationProcedure> processSpecificationProcedures = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!processSpecificationProcedureEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Process Specification Procedure list is empty");
        }
        // Convert Iterable to List
        for (ProcessSpecificationProcedureEntity processSpecificationProcedureEntity : processSpecificationProcedureEntities
        ) {
            ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity);
            processSpecificationProcedures.add(processSpecificationProcedure);
        }
        return processSpecificationProcedures;
    }

    private void validations(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validateProcessSpecificationProcedureName(processSpecificationProcedure.getName());
//        validateProcessSpecificationProcedureFile(processSpecificationProcedure.getProcedureFile());
//        validateProcessSpecificationProcedureQualificationRecordFile(processSpecificationProcedure.getProcessQualificationRecordFile());
        validateProcessSpecificationProcedureJointDesign(processSpecificationProcedure.getJointDesignName());
        validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterialName1());
        validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterialName2());
        validateProcessSpecificationProcedureFusionProcess(processSpecificationProcedure.getFusionProcessName());
        validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterialName1());
        validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterialName2());
        validateProcessSpecificationProcedureStandardCode(processSpecificationProcedure.getStandardCodeName());
//        validateProcessSpecificationProcedureIsPreheatRequired(processSpecificationProcedure.isPreheatRequired());
//        validateProcessSpecificationProcedureIsPostWeldHeatTreatmentRequired(processSpecificationProcedure.isPostWeldHeatTreatmentRequired());
        validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMinMm());
        validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMaxMm());
        validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMinInch());
        validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMaxInch());
//        validateProcessSpecificationProcedureThicknessUom(processSpecificationProcedure.getThicknessUom());
        validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMinMm());
        validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMaxMm());
    }

    private void validateProcessSpecificationProcedureStandardCode(String standardCodeName) throws Exception {
        List<StandardCode> standardCodes =  standardCodeLogic.getAll();

        for (StandardCode standardCode : standardCodes){
            if (standardCode.getName().equals(standardCodeName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.STANDARD_DOES_NOT_EXIST);
    }

    private void validateProcessSpecificationProcedureFusionProcess(String fusionProcessName) throws Exception {
        CommonValidations.validateIsExistInFusionProcesses(fusionProcessName);
    }

    private void validateProcessSpecificationProcedureJointDesign(String jointDesignName) throws Exception {
        CommonValidations.validateIsExistInJointDesigns(jointDesignName);
    }

    private void validateProcessSpecificationProcedureFillerMaterial(String fillerMaterialName) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(fillerMaterialName);
    }

    private void validateProcessSpecificationProcedureBaseMaterial(String baseMaterialName) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialName);
    }

    private void validateNumberInputNotNegative(Float number) throws ApplicationException {
        CommonValidations.validateNotNegative(number);
    }

    private void validateProcessSpecificationProcedureName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isProcessSpecificationProcedureExist(int id) {
        return this.processSpecificationProcedureDal.existsById(id);
    }
}
