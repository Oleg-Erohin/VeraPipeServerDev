package com.verapipe.specifications;

import com.verapipe.dto.*;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import com.verapipe.enums.UnitOfMeasure;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public class ProcessSpecificationProcedureSpecifications {

    public static Specification<ProcessSpecificationProcedureEntity> hasNames(Set<String> names) {
        return (root, query, cb) -> root.get("name").in(names);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasJointDesigns(Set<JointDesign> jointDesigns) {
        return (root, query, cb) -> root.get("jointDesign").in(jointDesigns);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasBaseMaterials(Set<BaseMaterialType> baseMaterialTypes) {
        return (root, query, cb) -> root.get("baseMaterialTypeList").in(baseMaterialTypes);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasFusionProcesses(Set<FusionProcess> fusionProcesses) {
        return (root, query, cb) -> root.get("fusionProcess").in(fusionProcesses);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasFillerMaterials(Set<FillerMaterialType> fillerMaterialTypes) {
        return (root, query, cb) -> root.get("fillerMaterialTypeList").in(fillerMaterialTypes);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasStandardCodes(Set<StandardCode> standardCodes) {
        return (root, query, cb) -> root.get("standardCode").in(standardCodes);
    }

    public static Specification<ProcessSpecificationProcedureEntity> isPreheatRequired(Boolean isPreheatRequired) {
        return (root, query, criteriaBuilder) ->
                isPreheatRequired == null ? null : criteriaBuilder.equal(root.get("isPreheatRequired"), isPreheatRequired);
    }

    public static Specification<ProcessSpecificationProcedureEntity> isPostWeldHeatTreatmentRequired(Boolean isPostWeldHeatTreatmentRequired) {
        return (root, query, criteriaBuilder) ->
                isPostWeldHeatTreatmentRequired == null ? null : criteriaBuilder.equal(root.get("isPostWeldHeatTreatmentRequired"), isPostWeldHeatTreatmentRequired);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasUnitsOfMeasure(Set<UnitOfMeasure> unitsOfMeasure) {
        return (root, query, cb) -> root.get("unitOfMeasure").in(unitsOfMeasure);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasDiameterMin(Set<Float> minDiameters) {
        return (root, query, cb) -> root.get("diameterMin").in(minDiameters);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasDiameterMax(Set<Float> maxDiameters) {
        return (root, query, cb) -> root.get("diameterMax").in(maxDiameters);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasThicknessMin(Set<Float> minThicknesses) {
        return (root, query, cb) -> root.get("thicknessMin").in(minThicknesses);
    }

    public static Specification<ProcessSpecificationProcedureEntity> hasThicknessMax(Set<Float> maxThicknesses) {
        return (root, query, cb) -> root.get("thicknessMax").in(maxThicknesses);
    }
}
