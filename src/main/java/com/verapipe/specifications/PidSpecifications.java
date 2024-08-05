package com.verapipe.specifications;

import com.verapipe.entities.PidEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.Set;

public class PidSpecifications {

    public static Specification<PidEntity> hasNames(Set<String> names) {
        return (root, query, cb) -> root.get("name").in(names);
    }

    public static Specification<PidEntity> hasRevisions(Set<String> revisions) {
        return (root, query, cb) -> root.get("revision").in(revisions);
    }

    public static Specification<PidEntity> hasDates(Set<Date> dates) {
        return (root, query, cb) -> root.get("date").in(dates);
    }
}
