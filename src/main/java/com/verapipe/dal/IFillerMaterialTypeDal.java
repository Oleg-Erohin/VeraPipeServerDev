package com.verapipe.dal;

import com.verapipe.entities.FillerMaterialTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFillerMaterialTypeDal extends PagingAndSortingRepository<FillerMaterialTypeEntity,Integer> {

}
