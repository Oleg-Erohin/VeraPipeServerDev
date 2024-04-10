package com.verapipe.dal;

import com.verapipe.entities.BaseMaterialTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBaseMaterialTypeDal extends CrudRepository<BaseMaterialTypeEntity,Integer> {

}
