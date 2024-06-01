package com.verapipe.dto;

import com.verapipe.entities.FileEntity;
import com.verapipe.enums.FileType;

import java.util.Arrays;

public class File {
    private int id;
    private FileType fileType;
    private String resourceName;
    private String revision;
    private byte[] file;

    public File() {
    }

    public File(FileType fileType, String resourceName, String revision, byte[] file) {
        this.fileType = fileType;
        this.resourceName = resourceName;
        this.revision = revision;
        this.file = file;
    }

    public File(int id, FileType fileType, String resourceName, String revision, byte[] file) {
        this.id = id;
        this.fileType = fileType;
        this.resourceName = resourceName;
        this.revision = revision;
        this.file = file;
    }

    public File(FileEntity fileEntity) {
        this.id = fileEntity.getId();
        this.fileType = fileEntity.getFileType();
        this.resourceName = fileEntity.getResourceName();
        this.revision = fileEntity.getRevision();
        this.file = fileEntity.getFile();
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

    public void setResourceName(String fileName) {
        this.resourceName = fileName;
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

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileType=" + fileType +
                ", resourceName='" + resourceName + '\'' +
                ", revision='" + revision + '\'' +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
