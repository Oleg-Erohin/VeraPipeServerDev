package com.verapipe.specifications;

import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.FusionProcess;
import com.verapipe.dto.JointDesign;
import com.verapipe.entities.JoinerEntity;
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

    public Specification<JoinerEntity> hasCertifiedDiameterMin(Set<Float> certifiedDiameterMin) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMin == null ? null : root.get("certifiedDiameterMin").in(certifiedDiameterMin);
    }

    public Specification<JoinerEntity> hasCertifiedDiameterMax(Set<Float> certifiedDiameterMax) {
        return (root, query, criteriaBuilder) ->
                certifiedDiameterMax == null ? null : root.get("certifiedDiameterMax").in(certifiedDiameterMax);
    }

    public Specification<JoinerEntity> hasMaxDepositedMaterial(Set<Float> maxDepositedMaterial) {
        return (root, query, criteriaBuilder) ->
                maxDepositedMaterial == null ? null : root.get("maxDepositedMaterial").in(maxDepositedMaterial);
    }

    public Specification<JoinerEntity> hasBaseMaterialTypesIn(Set<BaseMaterialType> baseMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (baseMaterialTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("baseMaterialTypeList", JoinType.LEFT).in(baseMaterialTypes);
            }
        };
    }

    public Specification<JoinerEntity> hasJointDesignsIn(Set<JointDesign> jointDesigns) {
        return (root, query, criteriaBuilder) ->
                jointDesigns == null ? null : root.get("jointDesign").in(jointDesigns);
    }

    public Specification<JoinerEntity> hasFusionProcessesIn(Set<FusionProcess> fusionProcesses) {
        return (root, query, criteriaBuilder) ->
                fusionProcesses == null ? null : root.get("fusionProcess").in(fusionProcesses);
    }
}
