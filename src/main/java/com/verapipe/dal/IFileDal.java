package com.verapipe.dal;

import com.verapipe.entities.FileEntity;
import com.verapipe.enums.FileType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
    List<FileEntity> findLastWithoutFileData(@Param("fileType") FileType fileType,
                                             @Param("resourceId") int resourceId,
                                             Pageable pageable);

    @Query("SELECT f.revision FROM FileEntity f WHERE f.resourceId = :resourceId AND f.fileType = :fileType")
    List<String> findRevisionsByResourceIdAndFileType(
            @Param("resourceId") int resourceId,
            @Param("fileType") FileType fileType
    );

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END " +
            "FROM FileEntity f WHERE f.fileType = :fileType AND f.resourceId = :resourceId")
    Boolean isFileExistByResource(@Param("fileType") FileType fileType,
                                  @Param("resourceId") int resourceId);


    @Modifying
    @Query("DELETE FROM FileEntity f WHERE f.fileType = :fileType AND f.resourceId = :resourceId")
    void deleteByFileTypeAndResourceId(@Param("fileType") FileType fileType,
                                       @Param("resourceId") int resourceId);

}
