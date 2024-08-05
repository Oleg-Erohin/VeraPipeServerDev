package com.verapipe.dal;

import com.verapipe.entities.PressureTestPackageEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPressureTestPackageDal extends PagingAndSortingRepository<PressureTestPackageEntity,Integer>, JpaSpecificationExecutor<PressureTestPackageEntity> {

}
