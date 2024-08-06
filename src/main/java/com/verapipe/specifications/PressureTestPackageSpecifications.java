package com.verapipe.specifications;

import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.entities.PressureTestPackageEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.Set;

public class PressureTestPackageSpecifications {

    public static Specification<PressureTestPackageEntity> hasNames(Set<String> names) {
        return (root, query, cb) -> root.get("name").in(names);
    }

    public static Specification<PressureTestPackageEntity> hasPids(Set<Pid> pids) {
        return (root, query, cb) -> root.get("pidsList").in(pids);
    }

    public static Specification<PressureTestPackageEntity> hasIsometrics(Set<Isometric> isometrics) {
        return (root, query, cb) -> root.get("isometricsList").in(isometrics);
    }

    public static Specification<PressureTestPackageEntity> hasDates(Set<Date> dates) {
        return (root, query, cb) -> root.get("date").in(dates);
    }
}
