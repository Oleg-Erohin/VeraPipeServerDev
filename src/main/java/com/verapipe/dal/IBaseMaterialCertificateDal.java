package com.verapipe.dal;

import com.verapipe.entities.BaseMaterialCertificateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBaseMaterialCertificateDal extends PagingAndSortingRepository<BaseMaterialCertificateEntity,Integer> {
//    BaseMaterialCertificateEntity findByHeatNumAndLotNum(String heatNum, String lotNum);
}
