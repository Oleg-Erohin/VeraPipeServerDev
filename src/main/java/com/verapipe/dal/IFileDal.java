package com.verapipe.dal;

import com.verapipe.entities.FileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFileDal extends PagingAndSortingRepository<FileEntity,Integer> {

//    boolean doesExistWithCurrentRevision(FileType fileType, String resourceName, String revision);
//
//    boolean doesFileExist();
}
