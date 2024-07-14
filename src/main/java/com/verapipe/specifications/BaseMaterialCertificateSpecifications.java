package com.verapipe.specifications;

import com.verapipe.entities.BaseMaterialCertificateEntity;
import com.verapipe.entities.BaseMaterialTypeEntity;
import com.verapipe.entities.JointEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Set;

@Service
public class BaseMaterialCertificateSpecifications {
    public Specification<BaseMaterialCertificateEntity> hasHeatNum(String heatNum) {
        return (root, query, criteriaBuilder) ->
                heatNum == null ? null : criteriaBuilder.equal(root.get("heatNum"), heatNum);
    }

    public Specification<BaseMaterialCertificateEntity> hasLotNum(String lotNum) {
        return (root, query, criteriaBuilder) ->
                lotNum == null ? null : criteriaBuilder.equal(root.get("lotNum"), lotNum);
    }

    public Specification<BaseMaterialCertificateEntity> hasBaseMaterialType(BaseMaterialTypeEntity baseMaterialType) {
        return (root, query, criteriaBuilder) ->
                baseMaterialType == null ? null : criteriaBuilder.equal(root.get("baseMaterialType"), baseMaterialType);
    }

    public Specification<BaseMaterialCertificateEntity> hasJointsIn(Set<JointEntity> jointsList) {
        return (root, query, criteriaBuilder) -> {
            if (jointsList == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("jointsList", JoinType.LEFT).in(jointsList);
            }
        };
    }
}
