package com.verapipe.specifications;

import com.verapipe.dto.FillerMaterialType;
import com.verapipe.entities.FillerMaterialCertificateEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.List;

@Service
public class FillerMaterialCertificateSpecifications {

    public Specification<FillerMaterialCertificateEntity> hasNameIn(List<String> names) {
        return (root, query, criteriaBuilder) ->
                names == null ? null : root.get("name").in(names);
    }

    public Specification<FillerMaterialCertificateEntity> hasHeatNumIn(List<String> heatNums) {
        return (root, query, criteriaBuilder) ->
                heatNums == null ? null : root.get("heatNum").in(heatNums);
    }

    public Specification<FillerMaterialCertificateEntity> hasFillerMaterialTypeIn(List<FillerMaterialType> fillerMaterialTypes) {
        return (root, query, criteriaBuilder) -> {
            if (fillerMaterialTypes == null) {
                return null;
            } else {
                return root.join("fillerMaterialType", JoinType.LEFT).get("typeName").in(fillerMaterialTypes);
            }
        };
    }

    public Specification<FillerMaterialCertificateEntity> hasJointNumsIn(List<String> jointNums) {
        return (root, query, criteriaBuilder) -> {
            if (jointNums == null) {
                return null;
            } else {
                query.distinct(true);
                return root.join("jointsList", JoinType.LEFT).get("jointNum").in(jointNums);
            }
        };
    }
}
