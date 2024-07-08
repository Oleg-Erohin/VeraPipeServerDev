package com.verapipe.specifications;

import com.verapipe.entities.BaseMaterialCertificateEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseMaterialCertificateSpecifications {
    public Specification<BaseMaterialCertificateEntity> hasHeatNumIn(List<String> heatNums) {
        return (root, query, criteriaBuilder) ->
                heatNums == null ? null : root.get("heatNum").in(heatNums);
    }

    public Specification<BaseMaterialCertificateEntity> hasLotNumIn(List<String> lotNums) {
        return (root, query, criteriaBuilder) ->
                lotNums == null ? null : root.get("lotNum").in(lotNums);
    }

    public Specification<BaseMaterialCertificateEntity> hasMaterialTypeNameIn(List<String> materialTypeNames) {
        return (root, query, criteriaBuilder) ->
                materialTypeNames == null ? null : root.get("materialTypeName").in(materialTypeNames);
    }
}
