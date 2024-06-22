package com.verapipe.dto;

import com.verapipe.entities.PipeWallThicknessEntity;

public class PipeWallThickness {
    private int id;
    private String nominalDiameterInch;
    private Float odInch;
    private Float odMm;
    private Float sch10;
    private Float sch20;
    private Float sch30;
    private Float schStd;
    private Float sch40;
    private Float sch60;
    private Float schXs;
    private Float sch80;
    private Float sch100;
    private Float sch120;
    private Float sch140;
    private Float sch160;
    private Float schXxs;
    private Float sch5S;
    private Float sch10S;
    private Float sch40S;
    private Float sch80S;

    public PipeWallThickness() {
    }

    public PipeWallThickness(String nominalDiameterInch, Float odInch, Float odMm, Float sch10, Float sch20, Float sch30, Float schStd, Float sch40, Float sch60, Float schXs, Float sch80, Float sch100, Float sch120, Float sch140, Float sch160, Float schXxs, Float sch5S, Float sch10S, Float sch40S, Float sch80S) {
        this.nominalDiameterInch = nominalDiameterInch;
        this.odInch = odInch;
        this.odMm = odMm;
        this.sch10 = sch10;
        this.sch20 = sch20;
        this.sch30 = sch30;
        this.schStd = schStd;
        this.sch40 = sch40;
        this.sch60 = sch60;
        this.schXs = schXs;
        this.sch80 = sch80;
        this.sch100 = sch100;
        this.sch120 = sch120;
        this.sch140 = sch140;
        this.sch160 = sch160;
        this.schXxs = schXxs;
        this.sch5S = sch5S;
        this.sch10S = sch10S;
        this.sch40S = sch40S;
        this.sch80S = sch80S;
    }

    public PipeWallThickness(int id, String nominalDiameterInch, Float odInch, Float odMm, Float sch10, Float sch20, Float sch30, Float schStd, Float sch40, Float sch60, Float schXs, Float sch80, Float sch100, Float sch120, Float sch140, Float sch160, Float schXxs, Float sch5S, Float sch10S, Float sch40S, Float sch80S) {
        this.id = id;
        this.nominalDiameterInch = nominalDiameterInch;
        this.odInch = odInch;
        this.odMm = odMm;
        this.sch10 = sch10;
        this.sch20 = sch20;
        this.sch30 = sch30;
        this.schStd = schStd;
        this.sch40 = sch40;
        this.sch60 = sch60;
        this.schXs = schXs;
        this.sch80 = sch80;
        this.sch100 = sch100;
        this.sch120 = sch120;
        this.sch140 = sch140;
        this.sch160 = sch160;
        this.schXxs = schXxs;
        this.sch5S = sch5S;
        this.sch10S = sch10S;
        this.sch40S = sch40S;
        this.sch80S = sch80S;
    }

    public PipeWallThickness(PipeWallThicknessEntity pipeWallThicknessEntity) {
        this.id = pipeWallThicknessEntity.getId();
        this.nominalDiameterInch = pipeWallThicknessEntity.getNominalDiameterInch();
        this.odInch = pipeWallThicknessEntity.getOdInch();
        this.odMm = pipeWallThicknessEntity.getOdMm();
        this.sch10 = pipeWallThicknessEntity.getSch10();
        this.sch20 = pipeWallThicknessEntity.getSch20();
        this.sch30 = pipeWallThicknessEntity.getSch30();
        this.schStd = pipeWallThicknessEntity.getSchStd();
        this.sch40 = pipeWallThicknessEntity.getSch40();
        this.sch60 = pipeWallThicknessEntity.getSch60();
        this.schXs = pipeWallThicknessEntity.getSchXs();
        this.sch80 = pipeWallThicknessEntity.getSch80();
        this.sch100 = pipeWallThicknessEntity.getSch100();
        this.sch120 = pipeWallThicknessEntity.getSch120();
        this.sch140 = pipeWallThicknessEntity.getSch140();
        this.sch160 = pipeWallThicknessEntity.getSch160();
        this.schXxs = pipeWallThicknessEntity.getSchXxs();
        this.sch5S = pipeWallThicknessEntity.getSch5S();
        this.sch10S = pipeWallThicknessEntity.getSch10S();
        this.sch40S = pipeWallThicknessEntity.getSch40S();
        this.sch80S = pipeWallThicknessEntity.getSch80S();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNominalDiameterInch() {
        return nominalDiameterInch;
    }

    public void setNominalDiameterInch(String nominalDiameterInch) {
        this.nominalDiameterInch = nominalDiameterInch;
    }

    public Float getOdInch() {
        return odInch;
    }

    public void setOdInch(Float odInch) {
        this.odInch = odInch;
    }

    public Float getOdMm() {
        return odMm;
    }

    public void setOdMm(Float odMm) {
        this.odMm = odMm;
    }

    public Float getSch10() {
        return sch10;
    }

    public void setSch10(Float sch10) {
        this.sch10 = sch10;
    }

    public Float getSch20() {
        return sch20;
    }

    public void setSch20(Float sch20) {
        this.sch20 = sch20;
    }

    public Float getSch30() {
        return sch30;
    }

    public void setSch30(Float sch30) {
        this.sch30 = sch30;
    }

    public Float getSchStd() {
        return schStd;
    }

    public void setSchStd(Float schStd) {
        this.schStd = schStd;
    }

    public Float getSch40() {
        return sch40;
    }

    public void setSch40(Float sch40) {
        this.sch40 = sch40;
    }

    public Float getSch60() {
        return sch60;
    }

    public void setSch60(Float sch60) {
        this.sch60 = sch60;
    }

    public Float getSchXs() {
        return schXs;
    }

    public void setSchXs(Float schXs) {
        this.schXs = schXs;
    }

    public Float getSch80() {
        return sch80;
    }

    public void setSch80(Float sch80) {
        this.sch80 = sch80;
    }

    public Float getSch100() {
        return sch100;
    }

    public void setSch100(Float sch100) {
        this.sch100 = sch100;
    }

    public Float getSch120() {
        return sch120;
    }

    public void setSch120(Float sch120) {
        this.sch120 = sch120;
    }

    public Float getSch140() {
        return sch140;
    }

    public void setSch140(Float sch140) {
        this.sch140 = sch140;
    }

    public Float getSch160() {
        return sch160;
    }

    public void setSch160(Float sch160) {
        this.sch160 = sch160;
    }

    public Float getSchXxs() {
        return schXxs;
    }

    public void setSchXxs(Float schXxs) {
        this.schXxs = schXxs;
    }

    public Float getSch5S() {
        return sch5S;
    }

    public void setSch5S(Float sch5S) {
        this.sch5S = sch5S;
    }

    public Float getSch10S() {
        return sch10S;
    }

    public void setSch10S(Float sch10S) {
        this.sch10S = sch10S;
    }

    public Float getSch40S() {
        return sch40S;
    }

    public void setSch40S(Float sch40S) {
        this.sch40S = sch40S;
    }

    public Float getSch80S() {
        return sch80S;
    }

    public void setSch80S(Float sch80S) {
        this.sch80S = sch80S;
    }

    @Override
    public String toString() {
        return "PipeWallThickness{" +
                "id=" + id +
                ", nominalDiameterInch='" + nominalDiameterInch + '\'' +
                ", odInch=" + odInch +
                ", odMm=" + odMm +
                ", sch10=" + sch10 +
                ", sch20=" + sch20 +
                ", sch30=" + sch30 +
                ", schStd=" + schStd +
                ", sch40=" + sch40 +
                ", sch60=" + sch60 +
                ", schXs=" + schXs +
                ", sch80=" + sch80 +
                ", sch100=" + sch100 +
                ", sch120=" + sch120 +
                ", sch140=" + sch140 +
                ", sch160=" + sch160 +
                ", schXxs=" + schXxs +
                ", sch5S=" + sch5S +
                ", sch10S=" + sch10S +
                ", sch40S=" + sch40S +
                ", sch80S=" + sch80S +
                '}';
    }
}
