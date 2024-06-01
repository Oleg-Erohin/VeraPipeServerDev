package com.verapipe.dal;

import com.verapipe.entities.FileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFileDal extends PagingAndSortingRepository<FileEntity,Integer> {

}
