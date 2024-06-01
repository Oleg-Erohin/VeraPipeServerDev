package com.verapipe.enums;

public enum FileExtension {
    PDF("application/pdf");

    private String fileExtension;

    FileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
