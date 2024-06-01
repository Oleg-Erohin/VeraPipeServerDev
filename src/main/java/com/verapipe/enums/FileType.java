package com.verapipe.enums;

public enum FileType {
    BASE_MATERIAL_CERTIFICATE("Base Material Certificate"),
    FILLER_MATERIAL_CERTIFICATE("Filler Material Certificate"),
    ISOMETRIC("Isometric"),
    JOINER("Joiner"),
    NDT_REPORT("NDT Report"),
    PID("P&ID"),
    POST_WELD_HEAT_TREATMENT("Post Weld Heat Treatment"),
    PREHEAT("Preheat"),
    PRESSURE_TEST_PACKAGE("Pressure Test Package"),
    PROCESS_SPECIFICATION_PROCEDURE("Process Specification Procedure"),
    PROCESS_QUALIFICATION_RECORD("Process Qualification Record");

    private String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
