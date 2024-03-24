package com.verapipe.dto;

import java.util.Arrays;
import java.util.Date;

public class Pid {
    private int id;
    private String name;
    private byte[] file;
    private String revision;
    private Date date;
    private int sheets;

    public Pid() {
    }

    public Pid(String name, byte[] file, String revision, Date date, int sheets) {
        this.name = name;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
    }

    public Pid(int id, String name, byte[] file, String revision, Date date, int sheets) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    @Override
    public String toString() {
        return "Pid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", file=" + Arrays.toString(file) +
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                '}';
    }
}
