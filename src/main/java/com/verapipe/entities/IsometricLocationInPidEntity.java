package com.verapipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.IsometricLocationInPid;
import com.verapipe.dto.IsometricLocationInSheet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "isometric_location_in_pid")
public class IsometricLocationInPidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private IsometricEntity isometric;

    @ManyToOne(fetch = FetchType.EAGER)
    private PidEntity pid;

    @OneToMany(mappedBy = "isometricLocationInPid")
    private List<IsometricLocationInSheetEntity> isometricLocationsInSheets;


    public IsometricLocationInPidEntity() {
    }

    public IsometricLocationInPidEntity(IsometricLocationInPid isometricLocationInPid) throws JsonProcessingException {
        this.id = isometricLocationInPid.getId();
        this.isometric = new IsometricEntity(isometricLocationInPid.getIsometric());
        this.pid = new PidEntity(isometricLocationInPid.getPid());
        this.isometricLocationsInSheets = initializeIsometricLocationsInSheets(isometricLocationInPid.getIsometricLocationsInSheets());
    }

    private List<IsometricLocationInSheetEntity> initializeIsometricLocationsInSheets(List<IsometricLocationInSheet> isometricLocationsInSheets) {
        List<IsometricLocationInSheetEntity> tempIsometricLocationsInSheetsEntities = new ArrayList<>();
        for (IsometricLocationInSheet isometricLocationInSheet : isometricLocationsInSheets) {
            IsometricLocationInSheetEntity isometricLocationInSheetEntity = new IsometricLocationInSheetEntity(isometricLocationInSheet);
            tempIsometricLocationsInSheetsEntities.add(isometricLocationInSheetEntity);
        }
        return tempIsometricLocationsInSheetsEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IsometricEntity getIsometric() {
        return isometric;
    }

    public void setIsometric(IsometricEntity isometric) {
        this.isometric = isometric;
    }

    public PidEntity getPid() {
        return pid;
    }

    public void setPid(PidEntity pid) {
        this.pid = pid;
    }

    public List<IsometricLocationInSheetEntity> getIsometricLocationsInSheets() {
        return isometricLocationsInSheets;
    }

    public void setIsometricLocationsInSheets(List<IsometricLocationInSheetEntity> isometricLocationsInSheets) {
        this.isometricLocationsInSheets = isometricLocationsInSheets;
    }
}
