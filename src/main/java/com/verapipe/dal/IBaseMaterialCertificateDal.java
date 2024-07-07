package com.verapipe.dal;

import com.verapipe.entities.BaseMaterialCertificateEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBaseMaterialCertificateDal extends PagingAndSortingRepository<BaseMaterialCertificateEntity,Integer>, JpaSpecificationExecutor<BaseMaterialCertificateEntity> {
//    BaseMaterialCertificateEntity findByHeatNumAndLotNum(String heatNum, String lotNum);
}
