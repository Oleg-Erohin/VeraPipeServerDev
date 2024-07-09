package com.verapipe.dal;

import com.verapipe.entities.BaseMaterialTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IBaseMaterialTypeDal extends PagingAndSortingRepository<BaseMaterialTypeEntity, Integer> {
    Optional<BaseMaterialTypeEntity> findByName(String name);
}
