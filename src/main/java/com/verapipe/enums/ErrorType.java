package com.verapipe.enums;

public enum ErrorType {
    GENERAL_ERROR(801, "An error has occurred while running", true),
    TEXT_TOO_LONG(802, "Text entered is too long", false),
    TEXT_TOO_SHORT(803, "Tet entered is too short", false),
    NEGATIVE_NUMBER(804, "The number entered cannot be negative", false),
    BASE_MATERIAL_TYPE_DOES_NOT_EXIST(805, "The base material type entered does not exist in existing base material types", false),
    FILLER_MATERIAL_TYPE_DOES_NOT_EXIST(806, "The filler material type entered does not exist in existing base material types", false),
    JOINT_DESIGN_DOES_NOT_EXIST(807, "The joint design does not exist in existing joint designs", false),
    FUSION_PROCESS_DOES_NOT_EXIST(808, "The fusion process does not exist in existing fusion processes", false),
    PROCESS_SPECIFICATION_PROCEDURE_DOES_NOT_EXIST(809, "The process specification procedure does not exist in existing process specification procedures", false),
    PID_DOES_NOT_EXIST(810, "The P&ID does not exist in existing P&IDs", false);

    private int errorNum;
    private String errorMessage;
    private boolean isShowStackTrace;

    ErrorType(int errorNum, String errorMessage, boolean isShowStackTrace) {
        this.errorNum = errorNum;
        this.errorMessage = errorMessage;
        this.isShowStackTrace = isShowStackTrace;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isShowStackTrace() {
        return isShowStackTrace;
    }

    public void setShowStackTrace(boolean showStackTrace) {
        isShowStackTrace = showStackTrace;
    }
}
