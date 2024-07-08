package com.verapipe.specifications;

import com.verapipe.entities.JointEntity;
import com.verapipe.entities.NdtReportEntity;
import com.verapipe.entities.NdtTypeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.List;

@Service
public class NdtReportSpecifications {
    public Specification<NdtReportEntity> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.equal(root.get("name"), name);
    }

    public Specification<NdtReportEntity> hasDate(Date date) {
        return (root, query, criteriaBuilder) ->
                date == null ? null : criteriaBuilder.equal(root.get("date"), date);
    }

    public Specification<NdtReportEntity> hasNdtType(NdtTypeEntity ndtType) {
        return (root, query, criteriaBuilder) ->
                ndtType == null ? null : criteriaBuilder.equal(root.get("ndtType"), ndtType);
    }

    public Specification<NdtReportEntity> hasJointsIn(List<JointEntity> joints) {
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
