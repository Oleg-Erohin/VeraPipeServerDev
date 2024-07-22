package com.verapipe.dal;

import com.verapipe.entities.FileEntity;
import com.verapipe.enums.FileType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFileDal extends PagingAndSortingRepository<FileEntity, Integer> {

    //    boolean doesExistWithCurrentRevision(FileType fileType, String resourceName, String revision);
    FileEntity findByFileTypeAndResourceIdAndRevision(FileType fileType, int resourceId, String revision);
    FileEntity findTopByFileTypeAndResourceIdOrderByUploadDateDesc(FileType fileType, int resourceId);

//
//    boolean doesFileExist();
}
