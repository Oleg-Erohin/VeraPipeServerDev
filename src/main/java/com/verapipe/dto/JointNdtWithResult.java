package com.verapipe.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.entities.JointNdtWithResultEntity;

public class JointNdtWithResult {
    private int id;
//    private Joint joint;
    private NdtReport ndtReport;
    private Boolean isPassed;

    public JointNdtWithResult() {
    }

    public JointNdtWithResult(Joint joint, NdtReport ndtReport, Boolean isPassed) {
//        this.joint = joint;
        this.ndtReport = ndtReport;
        this.isPassed = isPassed;
    }

    public JointNdtWithResult(int id, Joint joint, NdtReport ndtReport, Boolean isPassed) {
        this.id = id;
//        this.joint = joint;
        this.ndtReport = ndtReport;
        this.isPassed = isPassed;
    }

    public JointNdtWithResult(JointNdtWithResultEntity jointNdtWithResultEntity) throws JsonProcessingException {
        this.id = jointNdtWithResultEntity.getId();
//        this.joint = new Joint(jointNdtWithResultEntity.getJoint());
        this.ndtReport = new NdtReport(jointNdtWithResultEntity.getNdtReport());
        this.isPassed = jointNdtWithResultEntity.getPassed();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Joint getJoint() {
//        return joint;
//    }
//
//    public void setJoint(Joint joint) {
//        this.joint = joint;
//    }

    public NdtReport getNdtReport() {
        return ndtReport;
    }

    public void setNdtReport(NdtReport ndtReport) {
        this.ndtReport = ndtReport;
    }

    public Boolean getPassed() {
        return isPassed;
    }

    public void setPassed(Boolean passed) {
        isPassed = passed;
    }

    @Override
    public String toString() {
        return "JointNdtWithResult{" +
                "id=" + id +
//                ", joint=" + joint +
                ", ndtReport=" + ndtReport +
                ", isPassed=" + isPassed +
                '}';
    }
}
