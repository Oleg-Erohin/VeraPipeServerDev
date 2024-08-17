package com.verapipe.dal;

import com.verapipe.entities.FileEntity;
import com.verapipe.enums.FileType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IFileDal extends PagingAndSortingRepository<FileEntity, Integer> {

    //    boolean doesExistWithCurrentRevision(FileType fileType, String resourceName, String revision);
    FileEntity findByFileTypeAndResourceIdAndRevision(FileType fileType, int resourceId, String revision);
    FileEntity findTopByFileTypeAndResourceIdOrderByUploadDateDesc(FileType fileType, int resourceId);

    @Query("SELECT new com.verapipe.entities.FileEntity(f.id, f.name, f.fileType, f.resourceId, f.revision, f.uploadDate) " +
            "FROM FileEntity f WHERE f.fileType = :fileType AND f.resourceId = :resourceId AND f.revision = :revision")
    FileEntity findWithoutFileData(@Param("fileType") FileType fileType,
                                   @Param("resourceId") int resourceId,
                                   @Param("revision") String revision);

    @Query("SELECT new com.verapipe.entities.FileEntity(f.id, f.name, f.fileType, f.resourceId, f.revision, f.uploadDate) " +
            "FROM FileEntity f WHERE f.fileType = :fileType AND f.resourceId = :resourceId " +
            "ORDER BY f.uploadDate DESC")
    FileEntity findLastWithoutFileData(@Param("fileType") FileType fileType,
                                       @Param("resourceId") int resourceId);
}
