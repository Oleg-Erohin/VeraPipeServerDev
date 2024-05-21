package com.verapipe.dal;

import com.verapipe.entities.StandardCodeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStandardCodeDal extends PagingAndSortingRepository<StandardCodeEntity,Integer> {

}
