package com.verapipe.dto;

import com.verapipe.entities.FileEntity;
import com.verapipe.enums.FileType;

import java.util.Arrays;
import java.util.Date;

public class File {
    private int id;
    private String name;
    private String  strFileType;
    private FileType enumFileType;
    private int resourceId;
    private String revision;
    private byte[] file;
    private Date uploadDate;

    public File() {
    }

    public File(String  strFileType, int resourceId, String revision, byte[] file) {
        this.strFileType = strFileType;
        this.resourceId = resourceId;
        this.revision = revision;
        this.file = file;
        this.uploadDate = new Date();
    }

    public File(int id,String name, String  strFileType, int resourceId, String revision, byte[] file) {
        this.id = id;
        this.name = name;
        this.strFileType = strFileType;
        this.resourceId = resourceId;
        this.revision = revision;
        this.file = file;
    }

    public File(FileEntity fileEntity) {
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.enumFileType = fileEntity.getFileType();
        this.strFileType = enumFileType.getFileType();
        this.resourceId = fileEntity.getResourceId();
        this.revision = fileEntity.getRevision();
        this.file = fileEntity.getFile();
        this.uploadDate = fileEntity.getUploadDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getStrFileType() {
        return strFileType;
    }

    public void setStrFileType(String  strFileType) {
        this.strFileType = strFileType;
    }

    public FileType getEnumFileType() {
        return enumFileType;
    }

    public void setEnumFileType(FileType enumFileType) {
        this.enumFileType = enumFileType;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileType=" + strFileType +
                ", resourceId='" + resourceId + '\'' +
                ", revision='" + revision + '\'' +
                ", file=" + Arrays.toString(file) +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
