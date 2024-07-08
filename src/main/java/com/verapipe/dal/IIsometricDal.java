package com.verapipe.dal;

import com.verapipe.entities.IsometricEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IIsometricDal extends PagingAndSortingRepository<IsometricEntity,Integer>, JpaSpecificationExecutor<IsometricEntity> {

}
