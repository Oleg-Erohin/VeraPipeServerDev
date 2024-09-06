package com.verapipe.dto;

import com.verapipe.entities.IsometricLocationInPidEntity;
import com.verapipe.entities.IsometricLocationInSheetEntity;

import java.util.ArrayList;
import java.util.List;

public class IsometricLocationInPid {

    private int id;
    private Isometric isometric;
    private Pid pid;
    private List<IsometricLocationInSheet> isometricLocationsInSheets;

    public IsometricLocationInPid() {
    }

    public IsometricLocationInPid(Isometric isometric, Pid pid, List<IsometricLocationInSheet> isometricLocationsInSheets) {
        this.isometric = isometric;
        this.pid = pid;
        this.isometricLocationsInSheets = isometricLocationsInSheets;
    }

    public IsometricLocationInPid(int id, Isometric isometric, Pid pid, List<IsometricLocationInSheet> isometricLocationsInSheets) {
        this.id = id;
        this.isometric = isometric;
        this.pid = pid;
        this.isometricLocationsInSheets = isometricLocationsInSheets;
    }

    public IsometricLocationInPid(IsometricLocationInPidEntity isometricLocationInPidEntity) {
        this.id = isometricLocationInPidEntity.getId();
        this.isometric = new Isometric(isometricLocationInPidEntity.getIsometric());
        this.pid = new Pid(isometricLocationInPidEntity.getPid());
        this.isometricLocationsInSheets = initializeIsometricLocationsInSheets(isometricLocationInPidEntity.getIsometricLocationsInSheets());
    }

    private List<IsometricLocationInSheet> initializeIsometricLocationsInSheets(List<IsometricLocationInSheetEntity> isometricLocationsInSheets) {
        List<IsometricLocationInSheet> tempIsometricLocationsInSheets = new ArrayList<>();
        for (IsometricLocationInSheetEntity isometricLocationInSheetEntity : isometricLocationsInSheets) {
            IsometricLocationInSheet isometricLocationInSheet = new IsometricLocationInSheet(isometricLocationInSheetEntity);
            tempIsometricLocationsInSheets.add(isometricLocationInSheet);
        }
        return tempIsometricLocationsInSheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Isometric getIsometric() {
        return isometric;
    }

    public void setIsometric(Isometric isometric) {
        this.isometric = isometric;
    }

    public Pid getPid() {
        return pid;
    }

    public void setPid(Pid pid) {
        this.pid = pid;
    }

    public List<IsometricLocationInSheet> getIsometricLocationsInSheets() {
        return isometricLocationsInSheets;
    }

    public void setIsometricLocationsInSheets(List<IsometricLocationInSheet> isometricLocationsInSheets) {
        this.isometricLocationsInSheets = isometricLocationsInSheets;
    }

    @Override
    public String toString() {
        return "IsometricLocationInPid{" +
                "id=" + id +
                ", isometric=" + isometric +
                ", pid=" + pid +
                ", isometricLocationsInSheets=" + isometricLocationsInSheets +
                '}';
    }
}
