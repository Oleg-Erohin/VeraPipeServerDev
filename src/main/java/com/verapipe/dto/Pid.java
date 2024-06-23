package com.verapipe.dto;

import com.verapipe.entities.PidEntity;

import java.util.Date;

public class Pid {
    private int id;
    private String name;//
    private String revision;//
    private Date date;//
    private int sheets;//
    private String comments;

    public Pid() {
    }

    public Pid(String name, String revision, Date date, int sheets, String comments) {
        this.name = name;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.comments = comments;
    }

    public Pid(int id, String name, String revision, Date date, int sheets, String comments) {
        this.id = id;
        this.name = name;
        this.revision = revision;
        this.date = date;
        this.sheets = sheets;
        this.comments = comments;
    }

    public Pid(PidEntity pidEntity) {
        this.id = pidEntity.getId();
        this.name = pidEntity.getName();
        this.revision = pidEntity.getRevision();
        this.date = pidEntity.getDate();
        this.sheets = pidEntity.getSheets();
        this.comments = pidEntity.getComments();
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Pid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", revision='" + revision + '\'' +
                ", date=" + date +
                ", sheets=" + sheets +
                ", comments='" + comments + '\'' +
                '}';
    }
}
