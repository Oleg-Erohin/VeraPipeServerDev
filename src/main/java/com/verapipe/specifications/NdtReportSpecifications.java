package com.verapipe.specifications;

import com.verapipe.dto.NdtType;
import com.verapipe.entities.NdtReportEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.Set;

@Service
public class NdtReportSpecifications {

    public Specification<NdtReportEntity> hasNamesIn(Set<String> names) {
        return (root, query, criteriaBuilder) ->
                names == null ? null : root.get("name").in(names);
    }

    public Specification<NdtReportEntity> hasDatesIn(Set<Date> dates) {
        return (root, query, criteriaBuilder) ->
                dates == null ? null : root.get("date").in(dates);
    }

    public Specification<NdtReportEntity> hasNdtTypesIn(Set<NdtType> ndtTypes) {
        return (root, query, criteriaBuilder) -> {
            if (ndtTypes == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("ndtType", JoinType.LEFT).in(ndtTypes);
            }
        };
    }
}
