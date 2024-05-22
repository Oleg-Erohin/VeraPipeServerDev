package com.verapipe.dal;

import com.verapipe.entities.PidEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPidDal extends PagingAndSortingRepository<PidEntity,Integer> {

}
