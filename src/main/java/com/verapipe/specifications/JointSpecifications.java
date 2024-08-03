package com.verapipe.specifications;

import com.verapipe.dto.*;
import com.verapipe.entities.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.Set;

@Service
public class JointSpecifications {

    public Specification<JointEntity> hasNumbersIn(Set<Integer> numbers) {
        return (root, query, criteriaBuilder) ->
                numbers == null ? null : root.get("number").in(numbers);
    }

    public Specification<JointEntity> hasPidsIn(Set<Pid> pids) {
        return (root, query, criteriaBuilder) ->
                pids == null ? null : root.get("pid").in(pids);
    }

    public Specification<JointEntity> hasIsometricsIn(Set<Isometric> isometrics) {
        return (root, query, criteriaBuilder) ->
                isometrics == null ? null : root.get("isometric").in(isometrics);
    }

    public Specification<JointEntity> hasSchedulesIn(Set<String> schedules) {
        return (root, query, criteriaBuilder) ->
                schedules == null ? null : root.get("schedule").in(schedules);
    }

    public Specification<JointEntity> hasDiametersIn(Set<Float> diameters) {
        return (root, query, criteriaBuilder) ->
                diameters == null ? null : root.get("diameter").in(diameters);
    }

    public Specification<JointEntity> hasFittingDescriptionsIn(Set<String> fittingDescriptions) {
        return (root, query, criteriaBuilder) ->
                fittingDescriptions == null ? null : root.get("fittingDescription").in(fittingDescriptions);
    }

    public Specification<JointEntity> hasBaseMaterialTypesIn(Set<BaseMaterialType> baseMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialTypeList", JoinType.LEFT).in(baseMaterialTypes);
            }
        };
    }

    public Specification<JointEntity> hasBaseMaterialCertificatesIn(Set<BaseMaterialCertificate> baseMaterialCertificates) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialCertificates == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialCertificateList", JoinType.LEFT).in(baseMaterialCertificates);
            }
        };
    }

    public Specification<JointEntity> hasThicknessesIn(Set<Float> thicknesses) {
        return (root, query, criteriaBuilder) ->
                thicknesses == null ? null : root.get("thickness").in(thicknesses);
    }

    public Specification<JointEntity> hasFillerMaterialTypesIn(Set<FillerMaterialType> fillerMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (fillerMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("fillerMaterialTypeList", JoinType.LEFT).in(fillerMaterialTypes);
            }
        };
    }

    public Specification<JointEntity> hasFillerMaterialCertificatesIn(Set<FillerMaterialCertificate> fillerMaterialCertificates) {
        return (root, query, criteriaBuilder) -> {
            if (fillerMaterialCertificates == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("fillerMaterialCertificateList", JoinType.LEFT).in(fillerMaterialCertificates);
            }
        };
    }

    public Specification<JointEntity> hasProcessSpecificationProceduresIn(Set<ProcessSpecificationProcedure> processSpecificationProcedures) {
        return (root, query, criteriaBuilder) -> {
            if (processSpecificationProcedures == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("processSpecificationProcedureList", JoinType.LEFT).in(processSpecificationProcedures);
            }
        };
    }

    public Specification<JointEntity> hasJoinersIn(Set<Joiner> joiners) {
        return (root, query, criteriaBuilder) -> {
            if (joiners == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("joinersList", JoinType.LEFT).in(joiners);
            }
        };
    }

    public Specification<JointEntity> hasDatesIn(Set<Date> dates) {
        return (root, query, criteriaBuilder) ->
                dates == null ? null : root.get("date").in(dates);
    }

    public Specification<JointEntity> isFitUpDone(Boolean isFitUpDone) {
        return (root, query, criteriaBuilder) ->
                isFitUpDone == null ? null : criteriaBuilder.equal(root.get("isFitUpDone"), isFitUpDone);
    }

    public Specification<JointEntity> isVisualInspectionDone(Boolean isVisualInspectionDone) {
        return (root, query, criteriaBuilder) ->
                isVisualInspectionDone == null ? null : criteriaBuilder.equal(root.get("isVisualInspectionDone"), isVisualInspectionDone);
    }

    public Specification<JointEntity> hasNdtReportsIn(Set<NdtReportEntity> ndtReports) {
        return (root, query, criteriaBuilder) -> {
            if (ndtReports == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("ndtReportsList", JoinType.LEFT).in(ndtReports);
            }
        };
    }

    public Specification<JointEntity> isNdtPassed(Boolean isNdtPassed) {
        return (root, query, criteriaBuilder) ->
                isNdtPassed == null ? null : criteriaBuilder.equal(root.get("isNdtPassed"), isNdtPassed);
    }

    public Specification<JointEntity> hasPreheatsIn(Set<Preheat> preheats) {
        return (root, query, criteriaBuilder) -> {
            if (preheats == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("preheatList", JoinType.LEFT).in(preheats);
            }
        };
    }

    public Specification<JointEntity> hasPostWeldHeatTreatmentsIn(Set<PostWeldHeatTreatment> postWeldHeatTreatments) {
        return (root, query, criteriaBuilder) -> {
            if (postWeldHeatTreatments == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("postWeldHeatTreatmentList", JoinType.LEFT).in(postWeldHeatTreatments);
            }
        };
    }
}
