package com.verapipe.entities;

import javax.persistence.*;

@Entity
@Table(name = "pipe_wall_thickness")
public class PipeWallThicknessEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nominal_diameter_inch", unique = true, nullable = false)
    private String nominalDiameterInch;
    @Column(name = "od_inch", unique = false, nullable = false)
    private Float odInch;
    @Column(name = "od_mm", unique = false, nullable = false)
    private Float odMm;
    @Column(name = "sch_10", unique = false, nullable = true)
    private Float sch10;
    @Column(name = "sch_20", unique = false, nullable = true)
    private Float sch20;
    @Column(name = "sch_30", unique = false, nullable = true)
    private Float sch30;
    @Column(name = "sch_std", unique = false, nullable = true)
    private Float schStd;
    @Column(name = "sch_40", unique = false, nullable = true)
    private Float sch40;
    @Column(name = "sch_60", unique = false, nullable = true)
    private Float sch60;
    @Column(name = "sch_xs", unique = false, nullable = true)
    private Float schXs;
    @Column(name = "sch_80", unique = false, nullable = true)
    private Float sch80;
    @Column(name = "sch_100", unique = false, nullable = true)
    private Float sch100;
    @Column(name = "sch_120", unique = false, nullable = true)
    private Float sch120;
    @Column(name = "sch_140", unique = false, nullable = true)
    private Float sch140;
    @Column(name = "sch_160", unique = false, nullable = true)
    private Float sch160;
    @Column(name = "sch_XXS", unique = false, nullable = true)
    private Float schXxs;
    @Column(name = "sch_5S", unique = false, nullable = true)
    private Float sch5S;
    @Column(name = "sch_10S", unique = false, nullable = true)
    private Float sch10S;
    @Column(name = "sch_40S", unique = false, nullable = true)
    private Float sch40S;
    @Column(name = "sch_80S", unique = false, nullable = true)
    private Float sch80S;

    public PipeWallThicknessEntity() {
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
}
