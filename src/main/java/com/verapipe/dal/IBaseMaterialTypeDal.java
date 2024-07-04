package com.verapipe.dal;

import com.verapipe.entities.BaseMaterialTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBaseMaterialTypeDal extends PagingAndSortingRepository<BaseMaterialTypeEntity,Integer> {

}
