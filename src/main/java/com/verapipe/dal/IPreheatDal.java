package com.verapipe.dal;

import com.verapipe.entities.PreheatEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPreheatDal extends PagingAndSortingRepository<PreheatEntity,Integer> {

}
