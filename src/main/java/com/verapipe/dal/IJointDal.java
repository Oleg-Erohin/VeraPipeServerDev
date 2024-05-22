package com.verapipe.dal;

import com.verapipe.entities.JointEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IJointDal extends PagingAndSortingRepository<JointEntity,Integer> {

}
