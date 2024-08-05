package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IProcessSpecificationProcedureDal;
import com.verapipe.dto.*;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.enums.UnitOfMeasure;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.ProcessSpecificationProcedureSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public List<ProcessSpecificationProcedure> findProcessSpecificationProceduresByFilters(Set<String> names, Set<JointDesign> jointDesigns, Set<BaseMaterialType> baseMaterialTypes, Set<FusionProcess> fusionProcesses, Set<FillerMaterialType> fillerMaterialTypes, Set<StandardCode> standardCodes, Boolean isPreheatRequired, Boolean isPostWeldHeatTreatmentRequired, Set<UnitOfMeasure> unitsOfMeasure, Set<Float> minDiameters, Set<Float> maxDiameters, Set<Float> minThicknesses, Set<Float> maxThicknesses) throws Exception{
        Specification<ProcessSpecificationProcedureEntity> spec = Specification
                .where(ProcessSpecificationProcedureSpecifications.hasNames(names))
                .and(ProcessSpecificationProcedureSpecifications.hasJointDesigns(jointDesigns))
                .and(ProcessSpecificationProcedureSpecifications.hasBaseMaterials(baseMaterialTypes))
                .and(ProcessSpecificationProcedureSpecifications.hasFusionProcesses(fusionProcesses))
                .and(ProcessSpecificationProcedureSpecifications.hasFillerMaterials(fillerMaterialTypes))
                .and(ProcessSpecificationProcedureSpecifications.hasStandardCodes(standardCodes))
                .and(ProcessSpecificationProcedureSpecifications.isPreheatRequired(isPreheatRequired))
                .and(ProcessSpecificationProcedureSpecifications.isPostWeldHeatTreatmentRequired(isPostWeldHeatTreatmentRequired))
                .and(ProcessSpecificationProcedureSpecifications.hasUnitsOfMeasure(unitsOfMeasure))
                .and(ProcessSpecificationProcedureSpecifications.hasDiameterMin(minDiameters))
                .and(ProcessSpecificationProcedureSpecifications.hasDiameterMax(maxDiameters))
                .and(ProcessSpecificationProcedureSpecifications.hasThicknessMin(minThicknesses))
                .and(ProcessSpecificationProcedureSpecifications.hasThicknessMax(maxThicknesses));

        List<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntities = this.processSpecificationProcedureDal.findAll(spec);

        List<ProcessSpecificationProcedure> processSpecificationProcedures = new ArrayList<>();
        for (ProcessSpecificationProcedureEntity processSpecificationProcedureEntity : processSpecificationProcedureEntities){
            ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity);
            processSpecificationProcedures.add(processSpecificationProcedure);
        }

        return processSpecificationProcedures;
    }

    private void validations(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validateProcessSpecificationProcedureName(processSpecificationProcedure.getName());
        validateProcessSpecificationProcedureJointDesign(processSpecificationProcedure.getJointDesign());
        validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterial1());
        if (processSpecificationProcedure.getBaseMaterial2() != null) {
            validateProcessSpecificationProcedureBaseMaterial(processSpecificationProcedure.getBaseMaterial2());
        }
        validateProcessSpecificationProcedureFusionProcess(processSpecificationProcedure.getFusionProcess());
        validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterial1());
        if (processSpecificationProcedure.getFillerMaterial2() != null) {
            validateProcessSpecificationProcedureFillerMaterial(processSpecificationProcedure.getFillerMaterial2());
        }
        validateProcessSpecificationProcedureStandardCode(processSpecificationProcedure.getStandardCode());
//        validateProcessSpecificationProcedureIsPreheatRequired(processSpecificationProcedure.isPreheatRequired());
//        validateProcessSpecificationProcedureIsPostWeldHeatTreatmentRequired(processSpecificationProcedure.isPostWeldHeatTreatmentRequired());
        if (processSpecificationProcedure.getDiameterMin() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMin());
        }
        if (processSpecificationProcedure.getDiameterMax() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getDiameterMax());
        }
//        validateProcessSpecificationProcedureThicknessUom(processSpecificationProcedure.getThicknessUom());
        validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMin());
        if (processSpecificationProcedure.getThicknessMax() != null) {
            validateNumberInputNotNegative(processSpecificationProcedure.getThicknessMax());
        }
    }

    private void validateProcessSpecificationProcedureStandardCode(StandardCode standardCode) throws Exception {
        List<StandardCode> standardCodes = standardCodeLogic.getAll();

        for (StandardCode currentStandardCode : standardCodes) {
            if (currentStandardCode.equals(standardCode)) {
                return;
            }
        }
        throw new ApplicationException(ErrorType.STANDARD_DOES_NOT_EXIST);
    }

    private void validateProcessSpecificationProcedureFusionProcess(FusionProcess fusionProcess) throws Exception {
        CommonValidations.validateIsExistInFusionProcesses(fusionProcess);
    }

    private void validateProcessSpecificationProcedureJointDesign(JointDesign jointDesign) throws Exception {
        CommonValidations.validateIsExistInJointDesigns(jointDesign);
    }

    private void validateProcessSpecificationProcedureFillerMaterial(FillerMaterialType fillerMaterial) throws Exception {
        CommonValidations.validateIsExistInFillerMaterialTypes(fillerMaterial);
    }

    private void validateProcessSpecificationProcedureBaseMaterial(BaseMaterialType baseMaterialType) throws Exception {
        CommonValidations.validateIsExistInBaseMaterialTypes(baseMaterialType);
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
