package com.verapipe.entities;

import com.verapipe.dto.Coordinate;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
public class CoordinateEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "x", unique = false, nullable = false)
    private Float x;

    @Column(name = "y", unique = false, nullable = false)
    private Float y;

    @ManyToOne(fetch = FetchType.LAZY)
    private IsometricLocationInSheetEntity isometricLocationInSheet;

    @OneToOne(fetch = FetchType.LAZY)
    private JointEntity joint;

    public CoordinateEntity() {
    }

    public CoordinateEntity(int id, Float x, Float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public CoordinateEntity(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
