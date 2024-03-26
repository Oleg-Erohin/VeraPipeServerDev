package com.verapipe.entities;

import com.verapipe.dto.Coordinates;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "isometric")
public class IsometricEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Lob
    @Column(name = "file", unique = true, nullable = false)
    private byte[] file;
    @Column(name = "revision", nullable = false)
    private String revision;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "sheets", nullable = false)
    private int sheets;
    @Column(name = "coordinates")
    private List<Coordinates> coordinatesInPid;
    @Column(name = "is_approved", nullable = false)
    private boolean isApproved;
    @ManyToMany
    private List<PidEntity> pidsList;
//    @OneToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
//    private List<JointEntity> jointsList;
//    @ManyToMany(mappedBy = "isometric", fetch = FetchType.LAZY)
//    private List<PressureTestPackage> testPacksList;

}
