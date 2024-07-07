package com.verapipe.specifications;

import com.verapipe.entities.BaseMaterialCertificateEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class BaseMaterialCertificateSpecifications {
    public static Specification<BaseMaterialCertificateEntity> hasHeatNumIn(List<String> heatNums) {
        return (root, query, criteriaBuilder) ->
                heatNums == null ? null : root.get("heatNum").in(heatNums);
    }

    public static Specification<BaseMaterialCertificateEntity> hasLotNumIn(List<String> lotNums) {
        return (root, query, criteriaBuilder) ->
                lotNums == null ? null : root.get("lotNum").in(lotNums);
    }

    public static Specification<BaseMaterialCertificateEntity> hasMaterialTypeNameIn(List<String> materialTypeNames) {
        return (root, query, criteriaBuilder) ->
                materialTypeNames == null ? null : root.get("materialTypeName").in(materialTypeNames);
    }
}
