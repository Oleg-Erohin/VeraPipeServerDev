package com.verapipe.specifications;

import com.verapipe.entities.*;
import com.verapipe.enums.UnitOfMeasure;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.Set;

@Service
public class JointSpecifications {
    public Specification<JointEntity> hasNumber(Integer number) {
        return (root, query, criteriaBuilder) ->
                number == null ? null : criteriaBuilder.equal(root.get("number"), number);
    }

    public Specification<JointEntity> hasCoordinatesOnIsometric(String coordinatesOnIsometric) {
        return (root, query, criteriaBuilder) ->
                coordinatesOnIsometric == null ? null : criteriaBuilder.equal(root.get("coordinatesOnIsometric"), coordinatesOnIsometric);
    }

    public Specification<JointEntity> hasPid(PidEntity pid) {
        return (root, query, criteriaBuilder) ->
                pid == null ? null : criteriaBuilder.equal(root.get("pid"), pid);
    }

    public Specification<JointEntity> hasIsometric(IsometricEntity isometric) {
        return (root, query, criteriaBuilder) ->
                isometric == null ? null : criteriaBuilder.equal(root.get("isometric"), isometric);
    }

    public Specification<JointEntity> hasSheetOnIsometric(Integer sheetOnIsometric) {
        return (root, query, criteriaBuilder) ->
                sheetOnIsometric == null ? null : criteriaBuilder.equal(root.get("sheetOnIsometric"), sheetOnIsometric);
    }

    public Specification<JointEntity> hasUom(UnitOfMeasure uom) {
        return (root, query, criteriaBuilder) ->
                uom == null ? null : criteriaBuilder.equal(root.get("uom"), uom);
    }

    public Specification<JointEntity> hasSchedule(String schedule) {
        return (root, query, criteriaBuilder) ->
                schedule == null ? null : criteriaBuilder.equal(root.get("schedule"), schedule);
    }

    public Specification<JointEntity> hasDiameter(Float diameter) {
        return (root, query, criteriaBuilder) ->
                diameter == null ? null : criteriaBuilder.equal(root.get("diameter"), diameter);
    }

    public Specification<JointEntity> hasFittingDescription1(String fittingDescription1) {
        return (root, query, criteriaBuilder) ->
                fittingDescription1 == null ? null : criteriaBuilder.equal(root.get("fittingDescription1"), fittingDescription1);
    }

    public Specification<JointEntity> hasComments(String comments) {
        return (root, query, criteriaBuilder) ->
                comments == null ? null : criteriaBuilder.equal(root.get("comments"), comments);
    }

    public Specification<JointEntity> hasFittingDescription2(String fittingDescription2) {
        return (root, query, criteriaBuilder) ->
                fittingDescription2 == null ? null : criteriaBuilder.equal(root.get("fittingDescription2"), fittingDescription2);
    }

    public Specification<JointEntity> hasBaseMaterialTypesIn(Set<BaseMaterialTypeEntity> baseMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialTypeList", JoinType.LEFT).in(baseMaterialTypes);
            }
        };
    }

    public Specification<JointEntity> hasBaseMaterialCertificatesIn(Set<BaseMaterialCertificateEntity> baseMaterialCertificates) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialCertificates == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialCertificateList", JoinType.LEFT).in(baseMaterialCertificates);
            }
        };
    }

    public Specification<JointEntity> hasThickness(Float thickness) {
        return (root, query, criteriaBuilder) ->
                thickness == null ? null : criteriaBuilder.equal(root.get("thickness"), thickness);
    }

    public Specification<JointEntity> hasFillerMaterialTypesIn(Set<FillerMaterialTypeEntity> fillerMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (fillerMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("fillerMaterialTypeList", JoinType.LEFT).in(fillerMaterialTypes);
            }
        };
    }

    public Specification<JointEntity> hasFillerMaterialCertificatesIn(Set<FillerMaterialCertificateEntity> fillerMaterialCertificates) {
        return (root, query, criteriaBuilder) -> {
            if (fillerMaterialCertificates == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("fillerMaterialCertificateList", JoinType.LEFT).in(fillerMaterialCertificates);
            }
        };
    }

    public Specification<JointEntity> hasProcessSpecificationProcedure(ProcessSpecificationProcedureEntity processSpecificationProcedure) {
        return (root, query, criteriaBuilder) ->
                processSpecificationProcedure == null ? null : criteriaBuilder.equal(root.get("processSpecificationProcedure"), processSpecificationProcedure);
    }

    public Specification<JointEntity> hasJoinersIn(Set<JoinerEntity> joiners) {
        return (root, query, criteriaBuilder) -> {
            if (joiners == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("joinersList", JoinType.LEFT).in(joiners);
            }
        };
    }

    public Specification<JointEntity> hasDate(Date date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.equal(root.get("date"), date);
    }

    public Specification<JointEntity> isFitUpDone(Boolean isFitUpDone) {
        return (root, query, criteriaBuilder) ->
                isFitUpDone == null ? null : criteriaBuilder.equal(root.get("isFitUpDone"), isFitUpDone);
    }

    public Specification<JointEntity> isVisualInspectionDone(Boolean isVisualInspectionDone) {
        return (root, query, criteriaBuilder) ->
                isVisualInspectionDone == null ? null : criteriaBuilder.equal(root.get("isVisualInspectionDone"), isVisualInspectionDone);
    }

    public Specification<JointEntity> hasNdtReport(NdtReportEntity ndtReport) {
        return (root, query, criteriaBuilder) ->
                ndtReport == null ? null : criteriaBuilder.equal(root.get("ndtReport"), ndtReport);
    }

    public Specification<JointEntity> isNdtPassed(Boolean isNdtPassed) {
        return (root, query, criteriaBuilder) ->
                isNdtPassed == null ? null : criteriaBuilder.equal(root.get("isNdtPassed"), isNdtPassed);
    }

    public Specification<JointEntity> hasPreheat(PreheatEntity preheat) {
        return (root, query, criteriaBuilder) ->
                preheat == null ? null : criteriaBuilder.equal(root.get("preheat"), preheat);
    }

    public Specification<JointEntity> hasPostWeldHeatTreatment(PostWeldHeatTreatmentEntity postWeldHeatTreatment) {
        return (root, query, criteriaBuilder) ->
                postWeldHeatTreatment == null ? null : criteriaBuilder.equal(root.get("postWeldHeatTreatment"), postWeldHeatTreatment);
    }
}
