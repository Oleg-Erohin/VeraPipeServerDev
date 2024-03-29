package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "isometric")
public class PressureTestPackageEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany
    private List<PidEntity> pidsList;
    @ManyToMany
    private List<IsometricEntity> isometricsList;
    @Column(name = "coordinates")
    private List<Coordinates> coordinatesInPids;
    @Lob
    @Column(name = "test_report", unique = true, nullable = false)
    private byte[] testReport;
    @Column(name = "date", nullable = false)
    private Date date;
}
