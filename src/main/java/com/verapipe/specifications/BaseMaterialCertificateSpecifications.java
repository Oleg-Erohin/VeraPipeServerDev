package com.verapipe.specifications;

import com.verapipe.dto.BaseMaterialType;
import com.verapipe.entities.BaseMaterialCertificateEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseMaterialCertificateSpecifications {
    public Specification<BaseMaterialCertificateEntity> hasNameIn(List<String> names) {
        return (root, query, criteriaBuilder) ->
                names == null ? null : root.get("name").in(names);
    }

    public Specification<BaseMaterialCertificateEntity> hasHeatNumIn(List<String> heatNums) {
        return (root, query, criteriaBuilder) ->
                heatNums == null ? null : root.get("heatNum").in(heatNums);
    }

    public Specification<BaseMaterialCertificateEntity> hasLotNumIn(List<String> lotNums) {
        return (root, query, criteriaBuilder) ->
                lotNums == null ? null : root.get("lotNum").in(lotNums);
    }

    public Specification<BaseMaterialCertificateEntity> hasMaterialTypeNameIn(List<BaseMaterialType> materialTypes) {
        return (root, query, criteriaBuilder) ->
                materialTypes == null ? null : root.get("materialTypeName").in(materialTypes);
    }
}
