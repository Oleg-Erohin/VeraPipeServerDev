package com.verapipe.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test_pack_pids_and_isometrics")
public class PressureTestPackPidAndIsomtricsEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PressureTestPackageEntity pressureTestPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    private PidEntity pid;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<IsometricEntity> isometrics;

    public PressureTestPackPidAndIsomtricsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PressureTestPackageEntity getPressureTestPackage() {
        return pressureTestPackage;
    }

    public void setPressureTestPackage(PressureTestPackageEntity pressureTestPackage) {
        this.pressureTestPackage = pressureTestPackage;
    }

    public PidEntity getPid() {
        return pid;
    }

    public void setPid(PidEntity pid) {
        this.pid = pid;
    }

    public Set<IsometricEntity> getIsometrics() {
        return isometrics;
    }

    public void setIsometrics(Set<IsometricEntity> isometrics) {
        this.isometrics = isometrics;
    }
}
