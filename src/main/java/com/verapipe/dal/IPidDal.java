package com.verapipe.dal;

import com.verapipe.entities.PidEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPidDal extends CrudRepository<PidEntity,Integer> {

}
