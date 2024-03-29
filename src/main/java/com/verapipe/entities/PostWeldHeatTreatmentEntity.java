package com.verapipe.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post_weld_heat_treatment")
public class PostWeldHeatTreatmentEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "file")
    private byte[] file;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne
    private ProcessSpecificationProcedureEntity processSpecificationProcedure;
    @OneToMany(mappedBy = "post_weld_heat_treatment")
    private List<JointEntity> jointsList;

}
