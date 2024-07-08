package com.verapipe.dal;

import com.verapipe.entities.JoinerEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IJoinerDal extends PagingAndSortingRepository<JoinerEntity,Integer>, JpaSpecificationExecutor<JoinerEntity> {

}
