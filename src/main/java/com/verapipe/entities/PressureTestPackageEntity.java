package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.PressureTestPackage;
import com.verapipe.dto.PressureTestPackagePidAndIsometrics;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pressure_test_package")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "pressureTestPackage")
    private Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsometrics;

    @Column(name = "date", nullable = false)
    private Date date;

    public PressureTestPackageEntity() {
    }

    public PressureTestPackageEntity(PressureTestPackage pressureTestPackage) throws JsonProcessingException {
        this.id = pressureTestPackage.getId();
        this.name = pressureTestPackage.getName();
        this.pidsAndIsometrics = initializePidsAndIsometrics(pressureTestPackage.getPidsAndIsometrics());
        this.date = pressureTestPackage.getDate();
    }

    private Set<PressureTestPackPidAndIsomtricsEntity> initializePidsAndIsometrics(Set<PressureTestPackagePidAndIsometrics> pidsAndIsometrics) throws JsonProcessingException {
        Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsosEntities = new HashSet<>();
        for (PressureTestPackagePidAndIsometrics pidAndIsos: pidsAndIsometrics){
            PressureTestPackPidAndIsomtricsEntity pidAndIsometricsEntity = new PressureTestPackPidAndIsomtricsEntity(pidAndIsos);
            pidsAndIsosEntities.add(pidAndIsometricsEntity);
        }
        return pidsAndIsosEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PressureTestPackPidAndIsomtricsEntity> getPidsAndIsometrics() {
        return pidsAndIsometrics;
    }

    public void setPidsAndIsometrics(Set<PressureTestPackPidAndIsomtricsEntity> pidsAndIsometrics) {
        this.pidsAndIsometrics = pidsAndIsometrics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
