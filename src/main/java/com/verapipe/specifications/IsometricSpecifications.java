package com.verapipe.specifications;

import com.verapipe.dto.Pid;
import com.verapipe.entities.IsometricEntity;
import com.verapipe.entities.JointEntity;
import com.verapipe.entities.PressureTestPackageEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class IsometricSpecifications {

    public Specification<IsometricEntity> hasNameIn(List<String> names) {
        return (root, query, criteriaBuilder) ->
                names == null ? null : root.get("name").in(names);
    }

    public Specification<IsometricEntity> hasRevisionIn(List<String> revisions) {
        return (root, query, criteriaBuilder) ->
                revisions == null ? null : root.get("revision").in(revisions);
    }

    public Specification<IsometricEntity> hasDateIn(List<Date> dates) {
        return (root, query, criteriaBuilder) ->
                dates == null ? null : root.get("date").in(dates);
    }

    public Specification<IsometricEntity> hasSheetsIn(List<Integer> sheets) {
        return (root, query, criteriaBuilder) ->
                sheets == null ? null : root.get("sheets").in(sheets);
    }

    public Specification<IsometricEntity> hasCoordinatesInPidIn(List<String> coordinatesInPid) {
        return (root, query, criteriaBuilder) ->
                coordinatesInPid == null ? null : root.get("coordinatesInPid").in(coordinatesInPid);
    }

    public Specification<IsometricEntity> hasIsApproved(Boolean isApproved) {
        return (root, query, criteriaBuilder) ->
                isApproved == null ? null : criteriaBuilder.equal(root.get("isApproved"), isApproved);
    }

    public Specification<IsometricEntity> hasCommentsIn(List<String> comments) {
        return (root, query, criteriaBuilder) ->
                comments == null ? null : root.get("comments").in(comments);
    }

    public Specification<IsometricEntity> hasPidsIn(Set<Pid> pids) {
        return (root, query, criteriaBuilder) -> {
            if (pids == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("pidsList", JoinType.LEFT).in(pids);
            }
        };
    }

    public Specification<IsometricEntity> hasJointsIn(List<JointEntity> joints) {
        return (root, query, criteriaBuilder) -> {
            if (joints == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("jointsList", JoinType.LEFT).in(joints);
            }
        };
    }

    public Specification<IsometricEntity> hasTestPacksIn(Set<PressureTestPackageEntity> testPacks) {
        return (root, query, criteriaBuilder) -> {
            if (testPacks == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("testPacksList", JoinType.LEFT).in(testPacks);
            }
        };
    }
}
