package com.verapipe.dto;

import java.util.Arrays;

public class Joiner {
    private int id;
    private String tagId;
    private byte[] certificate;
    private Float certifiedDiameterMinMm;
    private Float certifiedDiameterMaxMm;
    private Float certifiedDiameterMinInch;
    private Float certifiedDiameterMaxInch;
    private Float maxDepositedMaterial;
    private BaseMaterialType baseMaterialType1;
    private BaseMaterialType baseMaterialType2;
    private JointDesign jointDesign;
    private FusionProcess fusionProcess;

    public Joiner() {
    }

    public Joiner(String tagId, byte[] certificate, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, FusionProcess fusionProcess) {
        this.tagId = tagId;
        this.certificate = certificate;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcess = fusionProcess;
    }

    public Joiner(int id, String tagId, byte[] certificate, Float certifiedDiameterMinMm, Float certifiedDiameterMaxMm, Float certifiedDiameterMinInch, Float certifiedDiameterMaxInch, Float maxDepositedMaterial, BaseMaterialType baseMaterialType1, BaseMaterialType baseMaterialType2, JointDesign jointDesign, FusionProcess fusionProcess) {
        this.id = id;
        this.tagId = tagId;
        this.certificate = certificate;
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
        this.maxDepositedMaterial = maxDepositedMaterial;
        this.baseMaterialType1 = baseMaterialType1;
        this.baseMaterialType2 = baseMaterialType2;
        this.jointDesign = jointDesign;
        this.fusionProcess = fusionProcess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public Float getCertifiedDiameterMinMm() {
        return certifiedDiameterMinMm;
    }

    public void setCertifiedDiameterMinMm(Float certifiedDiameterMinMm) {
        this.certifiedDiameterMinMm = certifiedDiameterMinMm;
    }

    public Float getCertifiedDiameterMaxMm() {
        return certifiedDiameterMaxMm;
    }

    public void setCertifiedDiameterMaxMm(Float certifiedDiameterMaxMm) {
        this.certifiedDiameterMaxMm = certifiedDiameterMaxMm;
    }

    public Float getCertifiedDiameterMinInch() {
        return certifiedDiameterMinInch;
    }

    public void setCertifiedDiameterMinInch(Float certifiedDiameterMinInch) {
        this.certifiedDiameterMinInch = certifiedDiameterMinInch;
    }

    public Float getCertifiedDiameterMaxInch() {
        return certifiedDiameterMaxInch;
    }

    public void setCertifiedDiameterMaxInch(Float certifiedDiameterMaxInch) {
        this.certifiedDiameterMaxInch = certifiedDiameterMaxInch;
    }

    public Float getMaxDepositedMaterial() {
        return maxDepositedMaterial;
    }

    public void setMaxDepositedMaterial(Float maxDepositedMaterial) {
        this.maxDepositedMaterial = maxDepositedMaterial;
    }

    public BaseMaterialType getBaseMaterialType1() {
        return baseMaterialType1;
    }

    public void setBaseMaterialType1(BaseMaterialType baseMaterialType1) {
        this.baseMaterialType1 = baseMaterialType1;
    }

    public BaseMaterialType getBaseMaterialType2() {
        return baseMaterialType2;
    }

    public void setBaseMaterialType2(BaseMaterialType baseMaterialType2) {
        this.baseMaterialType2 = baseMaterialType2;
    }

    public JointDesign getJointDesign() {
        return jointDesign;
    }

    public void setJointDesign(JointDesign jointDesign) {
        this.jointDesign = jointDesign;
    }

    public FusionProcess getFusionProcess() {
        return fusionProcess;
    }

    public void setFusionProcess(FusionProcess fusionProcess) {
        this.fusionProcess = fusionProcess;
    }

    @Override
    public String toString() {
        return "Joiner{" +
                "id=" + id +
                ", tagId='" + tagId + '\'' +
                ", certificate=" + Arrays.toString(certificate) +
                ", certifiedDiameterMinMm=" + certifiedDiameterMinMm +
                ", certifiedDiameterMaxMm=" + certifiedDiameterMaxMm +
                ", certifiedDiameterMinInch=" + certifiedDiameterMinInch +
                ", certifiedDiameterMaxInch=" + certifiedDiameterMaxInch +
                ", maxDepositedMaterial=" + maxDepositedMaterial +
                ", baseMaterialType1=" + baseMaterialType1 +
                ", baseMaterialType2=" + baseMaterialType2 +
                ", jointDesign=" + jointDesign +
                ", fusionProcess=" + fusionProcess +
                '}';
    }
}
