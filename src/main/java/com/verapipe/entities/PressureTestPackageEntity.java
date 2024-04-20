package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verapipe.dto.PressureTestPackage;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pressure_test_package")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<PidEntity> pidsList;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<IsometricEntity> isometricsList;
    @Column(name = "coordinates", unique = true, nullable = true)
    private String coordinatesInPids;
    @Lob
    @Column(name = "test_report", unique = true, nullable = false)
    private byte[] testReport;
    @Column(name = "date", nullable = false)
    private Date date;

    public PressureTestPackageEntity() {
    }

    public PressureTestPackageEntity(PressureTestPackage pressureTestPackage) throws JsonProcessingException {
        this.id = pressureTestPackage.getId();
        this.name = pressureTestPackage.getName();
        List<String> pidNames = pressureTestPackage.getPidNames();
        for (String pidName : pidNames){
            PidEntity tempPidEntity = new PidEntity();
            tempPidEntity.setName(pidName);
            this.pidsList.add(tempPidEntity);
        }
        List<String> isometricNames = pressureTestPackage.getIsometricNames();
        for (String isometricName : isometricNames){
            IsometricEntity tempIsometricEntity = new IsometricEntity();
            tempIsometricEntity.setName(isometricName);
            this.isometricsList.add(tempIsometricEntity);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        this.coordinatesInPids = objectMapper.writeValueAsString(pressureTestPackage.getCoordinatesInPidsList());
        this.testReport = pressureTestPackage.getTestReport();
        this.date = pressureTestPackage.getDate();
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

    public Set<PidEntity> getPidsList() {
        return pidsList;
    }

    public void setPidsList(Set<PidEntity> pidsList) {
        this.pidsList = pidsList;
    }

    public Set<IsometricEntity> getIsometricsList() {
        return isometricsList;
    }

    public void setIsometricsList(Set<IsometricEntity> isometricsList) {
        this.isometricsList = isometricsList;
    }

    public String getCoordinatesInPids() {
        return coordinatesInPids;
    }

    public void setCoordinatesInPids(String coordinatesInPids) {
        this.coordinatesInPids = coordinatesInPids;
    }

    public byte[] getTestReport() {
        return testReport;
    }

    public void setTestReport(byte[] testReport) {
        this.testReport = testReport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
