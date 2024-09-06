package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.JointNdtWithResult;

import javax.persistence.*;

@Entity
@Table(name = "joint_ndt_with_result")
public class JointNdtWithResultEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private JointEntity joint;
    @ManyToOne(fetch = FetchType.EAGER)
    private NdtReportEntity ndtReport;
    @Column(name = "isPassed", unique = false, nullable = false)
    private Boolean isPassed;

    public JointNdtWithResultEntity() {
    }

    public JointNdtWithResultEntity(JointNdtWithResult jointNdtWithResult) throws JsonProcessingException {
        this.id = jointNdtWithResult.getId();
//        this.joint = new JointEntity(jointNdtWithResult.getJoint());
        this.ndtReport = new NdtReportEntity(jointNdtWithResult.getNdtReport());
        this.isPassed = jointNdtWithResult.getPassed();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public JointEntity getJoint() {
//        return joint;
//    }
//
//    public void setJoint(JointEntity joint) {
//        this.joint = joint;
//    }

    public NdtReportEntity getNdtReport() {
        return ndtReport;
    }

    public void setNdtReport(NdtReportEntity ndtReport) {
        this.ndtReport = ndtReport;
    }

    public Boolean getPassed() {
        return isPassed;
    }

    public void setPassed(Boolean passed) {
        isPassed = passed;
    }
}
