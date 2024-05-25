package com.verapipe.enums;

public enum FileTypes {
    PDF("application/pdf");

    private String fileType;

    FileTypes(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
