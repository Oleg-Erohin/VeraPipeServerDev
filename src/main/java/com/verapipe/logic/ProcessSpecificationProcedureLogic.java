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
import org.springframework.cache.annotation.CacheEvict;
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

    @CacheEvict(cacheNames = "processSpecificationProceduresCache", allEntries = true)
    public int add(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity processSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.save(processSpecificationProcedureEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedProcessSpecificationProcedureId = processSpecificationProcedureEntity.getId();
        return addedProcessSpecificationProcedureId;
    }

    @CacheEvict(cacheNames = "processSpecificationProceduresCache", allEntries = true)
    public void update(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity sentProcessSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        try {
            this.processSpecificationProcedureDal.save(sentProcessSpecificationProcedureEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    @CacheEvict(cacheNames = "processSpecificationProceduresCache", allEntries = true)
    public void delete(int id) throws Exception {
        if (!isProcessSpecificationProcedureExist(id)) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_DOES_NOT_EXIST);
        }
        try {
            this.processSpecificationProcedureDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_PROCESS_SPECIFICATION_PROCEDURE);
        }
    }

    public ProcessSpecificationProcedure getById(int id) throws Exception {
        Optional<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntity;
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_COULD_NOT_BE_FOUND);
        }
        if (processSpecificationProcedureEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_DOES_NOT_EXIST);
        }
        ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity.get());
        return processSpecificationProcedure;
    }

    @Cacheable(cacheNames = "processSpecificationProceduresCache", key = "#root.methodName")
    public List<ProcessSpecificationProcedure> getAll() throws Exception {
        Iterable<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntities;
        List<ProcessSpecificationProcedure> processSpecificationProcedures = new ArrayList<>();
        try{
            processSpecificationProcedureEntities = this.processSpecificationProcedureDal.findAll();
            // Convert Iterable to List
            for (ProcessSpecificationProcedureEntity processSpecificationProcedureEntity : processSpecificationProcedureEntities
            ) {
                ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity);
                processSpecificationProcedures.add(processSpecificationProcedure);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PROCESS_SPECIFICATION_PROCEDURE_COULD_NOT_BE_FOUND);
        }
        return processSpecificationProcedures;
    }

    private void validations(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validateProcessSpecificationProcedureName(processSpecificationProcedure.getName());
        validateProcessSpecificationProcedureJointDesign(processSpecificationProcedure.getJointDesignName());
        validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterialName1());
        if (processSpecificationProcedure.getBaseMaterialName2() != null) {
            validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterialName2());
        }
        validateProcessSpecificationProcedureFusionProcess(processSpecificationProcedure.getFusionProcessName());
        validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterialName1());
        if (processSpecificationProcedure.getFillerMaterialName2() != null) {
            validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterialName2());
        }
        validateProcessSpecificationProcedureStandardCode(processSpecificationProcedure.getStandardCodeName());
//        validateProcessSpecificationProcedureIsPreheatRequired(processSpecificationProcedure.isPreheatRequired());
//        validateProcessSpecificationProcedureIsPostWeldHeatTreatmentRequired(processSpecificationProcedure.isPostWeldHeatTreatmentRequired());
        if (processSpecificationProcedure.getDiameterMinMm() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMinMm());
        }
        if (processSpecificationProcedure.getDiameterMaxMm() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMaxMm());
        }
        if (processSpecificationProcedure.getDiameterMinInch() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMinInch());
        }
        if (processSpecificationProcedure.getDiameterMaxInch() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMaxInch());
        }
//        validateProcessSpecificationProcedureThicknessUom(processSpecificationProcedure.getThicknessUom());
        validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMinMm());
        if (processSpecificationProcedure.getThicknessMaxMm() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMaxMm());
        }
    }

    private void validateProcessSpecificationProcedureStandardCode(String standardCodeName) throws Exception {
        List<StandardCode> standardCodes = standardCodeLogic.getAll();

        for (StandardCode standardCode : standardCodes) {
            if (standardCode.getName().equals(standardCodeName)) {
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

    public ProcessSpecificationProcedure getByName(String processSpecificationProcedureName) {
        return this.processSpecificationProcedureDal.findByName(processSpecificationProcedureName);
    }
}
