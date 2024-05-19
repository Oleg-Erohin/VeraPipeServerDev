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
    private float odInch;
    @Column(name = "od_mm", unique = false, nullable = false)
    private float odMm;
    @Column(name = "sch_10", unique = false, nullable = true)
    private float sch10;
    @Column(name = "sch_20", unique = false, nullable = true)
    private float sch20;
    @Column(name = "sch_30", unique = false, nullable = true)
    private float sch30;
    @Column(name = "sch_std", unique = false, nullable = true)
    private float schStd;
    @Column(name = "sch_40", unique = false, nullable = true)
    private float sch40;
    @Column(name = "sch_60", unique = false, nullable = true)
    private float sch60;
    @Column(name = "sch_xs", unique = false, nullable = true)
    private float schXs;
    @Column(name = "sch_80", unique = false, nullable = true)
    private float sch80;
    @Column(name = "sch_100", unique = false, nullable = true)
    private float sch100;
    @Column(name = "sch_120", unique = false, nullable = true)
    private float sch120;
    @Column(name = "sch_140", unique = false, nullable = true)
    private float sch140;
    @Column(name = "sch_160", unique = false, nullable = true)
    private float sch160;
    @Column(name = "sch_XXS", unique = false, nullable = true)
    private float schXxs;
    @Column(name = "sch_5S", unique = false, nullable = true)
    private float sch5S;
    @Column(name = "sch_10S", unique = false, nullable = true)
    private float sch10S;
    @Column(name = "sch_40S", unique = false, nullable = true)
    private float sch40S;
    @Column(name = "sch_80S", unique = false, nullable = true)
    private float sch80S;

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

    public float getOdInch() {
        return odInch;
    }

    public void setOdInch(float odInch) {
        this.odInch = odInch;
    }

    public float getOdMm() {
        return odMm;
    }

    public void setOdMm(float odMm) {
        this.odMm = odMm;
    }

    public float getSch10() {
        return sch10;
    }

    public void setSch10(float sch10) {
        this.sch10 = sch10;
    }

    public float getSch20() {
        return sch20;
    }

    public void setSch20(float sch20) {
        this.sch20 = sch20;
    }

    public float getSch30() {
        return sch30;
    }

    public void setSch30(float sch30) {
        this.sch30 = sch30;
    }

    public float getSchStd() {
        return schStd;
    }

    public void setSchStd(float schStd) {
        this.schStd = schStd;
    }

    public float getSch40() {
        return sch40;
    }

    public void setSch40(float sch40) {
        this.sch40 = sch40;
    }

    public float getSch60() {
        return sch60;
    }

    public void setSch60(float sch60) {
        this.sch60 = sch60;
    }

    public float getSchXs() {
        return schXs;
    }

    public void setSchXs(float schXs) {
        this.schXs = schXs;
    }

    public float getSch80() {
        return sch80;
    }

    public void setSch80(float sch80) {
        this.sch80 = sch80;
    }

    public float getSch100() {
        return sch100;
    }

    public void setSch100(float sch100) {
        this.sch100 = sch100;
    }

    public float getSch120() {
        return sch120;
    }

    public void setSch120(float sch120) {
        this.sch120 = sch120;
    }

    public float getSch140() {
        return sch140;
    }

    public void setSch140(float sch140) {
        this.sch140 = sch140;
    }

    public float getSch160() {
        return sch160;
    }

    public void setSch160(float sch160) {
        this.sch160 = sch160;
    }

    public float getSchXxs() {
        return schXxs;
    }

    public void setSchXxs(float schXxs) {
        this.schXxs = schXxs;
    }

    public float getSch5S() {
        return sch5S;
    }

    public void setSch5S(float sch5S) {
        this.sch5S = sch5S;
    }

    public float getSch10S() {
        return sch10S;
    }

    public void setSch10S(float sch10S) {
        this.sch10S = sch10S;
    }

    public float getSch40S() {
        return sch40S;
    }

    public void setSch40S(float sch40S) {
        this.sch40S = sch40S;
    }

    public float getSch80S() {
        return sch80S;
    }

    public void setSch80S(float sch80S) {
        this.sch80S = sch80S;
    }
}
