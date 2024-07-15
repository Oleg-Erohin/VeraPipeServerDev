package com.verapipe.entities;

import javax.persistence.*;

@Entity
@Table(name = "joint_ndt_report")
public class JointNdtReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private JointEntity joint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private NdtReportEntity ndtReport;

    @Column(name = "is_passed", nullable = false)
    private boolean isPassed;

    public JointNdtReportEntity() {}

    public JointNdtReportEntity(JointEntity joint, NdtReportEntity ndtReport, boolean isPassed) {
        this.joint = joint;
        this.ndtReport = ndtReport;
        this.isPassed = isPassed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JointEntity getJoint() {
        return joint;
    }

    public void setJoint(JointEntity joint) {
        this.joint = joint;
    }

    public NdtReportEntity getNdtReport() {
        return ndtReport;
    }

    public void setNdtReport(NdtReportEntity ndtReport) {
        this.ndtReport = ndtReport;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }
}
