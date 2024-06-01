package com.verapipe.enums;

import com.verapipe.consts.Consts;

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
    PID_DOES_NOT_EXIST(810, "The P&ID does not exist in existing P&IDs", false),
    ISOMETRIC_DOES_NOT_EXIST(811, "The isometric does not exist in existing isometrics", false),
    BASE_MATERIAL_CERTIFICATE_DOES_NOT_EXIST(812, "The base material certificate does not exist in existing base material certificates", false),
    FILLER_MATERIAL_CERTIFICATE_DOES_NOT_EXIST(813, "The filler material certificate does not exist in existing filler material certificates", false),
    STANDARD_DOES_NOT_EXIST(814, "The standard/code does not exist in existing standards/codes", false),
    NDT_TYPE_DOES_NOT_EXIST(815, "The NDT type does not exist in existing NDT types", false),
    NDT_REPORT_DOES_NOT_EXIST(816, "The NDT report does not exist in existing NDT reports", false),
    PREHEAT_DOES_NOT_EXIST(817, "The preheat does not exist in existing preheats", false),
    POST_WELD_HEAT_TREATMENT_DOES_NOT_EXIST(818, "The post weld heat treatment does not exist in existing post weld heat treatments", false),
    TOO_MANY_JOINER_TAGS(819, "There are too many joiners in the joiners list for this joint", false),
    JOINER_DOES_NOT_EXIST(820, "The joiner does not exist in existing joiners", false),
    FILE_SIZE_EXCEED_MAX_SIZE(821, "The file size exceed the max size of " + Consts.bytesIn20MB /1048576 + "MB",false),
    DATE_AND_TIME_IS_LATER_THAN_CURRENT_DATE_AND_TIME(822, "The date is later than today, change date for today or earlier", false),
    FILE_EXTENSION_IS_NOT_ALLOWED(823, "The file extension is not allowed", false);

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
