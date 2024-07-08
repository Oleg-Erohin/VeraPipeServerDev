package com.verapipe.specifications;

import com.verapipe.entities.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Set;
@Service
public class JoinerSpecifications {
    public Specification<JoinerEntity> hasTagIdIn(Set<String> tagIds) {
        return (root, query, criteriaBuilder) ->
                tagIds == null ? null : root.get("tagId").in(tagIds);
    }

    public Specification<JoinerEntity> hasCertifiedDiameterMinMm(Float certifiedDiameterMinMm) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMinMm == null ? null : criteriaBuilder.equal(root.get("certifiedDiameterMinMm"), certifiedDiameterMinMm);
    }

    public Specification<JoinerEntity> hasCertifiedDiameterMaxMm(Float certifiedDiameterMaxMm) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMaxMm == null ? null : criteriaBuilder.equal(root.get("certifiedDiameterMaxMm"), certifiedDiameterMaxMm);
    }

    public Specification<JoinerEntity> hasCertifiedDiameterMinInch(Float certifiedDiameterMinInch) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMinInch == null ? null : criteriaBuilder.equal(root.get("certifiedDiameterMinInch"), certifiedDiameterMinInch);
    }

    public Specification<JoinerEntity> hasCertifiedDiameterMaxInch(Float certifiedDiameterMaxInch) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMaxInch == null ? null : criteriaBuilder.equal(root.get("certifiedDiameterMaxInch"), certifiedDiameterMaxInch);
    }

    public Specification<JoinerEntity> hasMaxDepositedMaterial(Float maxDepositedMaterial) {
        return (root, query, criteriaBuilder) ->
                maxDepositedMaterial == null ? null : criteriaBuilder.equal(root.get("maxDepositedMaterial"), maxDepositedMaterial);
    }

    public Specification<JoinerEntity> hasBaseMaterialTypesIn(Set<BaseMaterialTypeEntity> baseMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialTypeList", JoinType.LEFT).in(baseMaterialTypes);
            }
        };
    }

    public Specification<JoinerEntity> hasJointDesign(JointDesignEntity jointDesign) {
        return (root, query, criteriaBuilder) ->
                jointDesign == null ? null : criteriaBuilder.equal(root.get("jointDesign"), jointDesign);
    }

    public Specification<JoinerEntity> hasFusionProcess(FusionProcessEntity fusionProcess) {
        return (root, query, criteriaBuilder) ->
                fusionProcess == null ? null : criteriaBuilder.equal(root.get("fusionProcess"), fusionProcess);
    }

    public Specification<JoinerEntity> hasJointsIn(Set<JointEntity> joints) {
        return (root, query, criteriaBuilder) -> {
            if (joints == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("jointsList", JoinType.LEFT).in(joints);
            }
        };
    }
}
