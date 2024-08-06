package com.verapipe.specifications;

import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.entities.PostWeldHeatTreatmentEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.Set;

public class PostWeldHeatTreatmentSpecifications {

    public static Specification<PostWeldHeatTreatmentEntity> hasNames(Set<String> names) {
        return (root, query, cb) -> root.get("name").in(names);
    }

    public static Specification<PostWeldHeatTreatmentEntity> hasProcessSpecificationProcedures(Set<ProcessSpecificationProcedure> processSpecificationProcedures) {
        return (root, query, cb) -> root.get("processSpecificationProcedure").in(processSpecificationProcedures);
    }

    public static Specification<PostWeldHeatTreatmentEntity> hasDates(Set<Date> dates) {
        return (root, query, cb) -> root.get("date").in(dates);
    }
}
