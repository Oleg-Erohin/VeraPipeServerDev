package com.verapipe.enums;

public enum FileType {
    BASE_MATERIAL_CERTIFICATE("BaseMaterialCertificate"),
    FILLER_MATERIAL_CERTIFICATE("FillerMaterialCertificate"),
    ISOMETRIC("Isometric"),
    JOINER("Joiner"),
    NDT_REPORT("NdtReport"),
    PID("Pid"),
    POST_WELD_HEAT_TREATMENT("PostWeldHeatTreatment"),
    PREHEAT("Preheat"),
    PRESSURE_TEST_PACKAGE("PressureTestPackage"),
    PROCESS_SPECIFICATION_PROCEDURE("ProcessSpecificationProcedure"),
    PROCESS_QUALIFICATION_RECORD("ProcessQualificationRecord");

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
    public static FileType fromString(String text) {
        for (FileType ft : FileType.values()) {
            if (ft.fileType.equalsIgnoreCase(text)) {
                return ft;
            }
        }
        throw new IllegalArgumentException("No enum constant with text " + text);
    }
}
