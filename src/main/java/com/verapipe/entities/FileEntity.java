package com.verapipe.entities;

import com.verapipe.dto.File;
import com.verapipe.enums.FileType;

import javax.persistence.*;

@Entity
@Table(name="file")
public class FileEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "file_type", unique = false, nullable = false)
    private FileType fileType;
    @Column(name = "resource_name", unique = false, nullable = false)
    private String resourceName;
    @Column(name = "revision", unique = false, nullable = false)
    private String revision;
    @Lob
    @Column(name = "file", unique = false, nullable = false)
    private byte[] file;

    public FileEntity() {
    }

    public FileEntity(File file) {
        this.id = file.getId();
        this.fileType = file.getFileType();
        this.resourceName = file.getResourceName();
        this.revision = file.getRevision();
        this.file = file.getFile();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
