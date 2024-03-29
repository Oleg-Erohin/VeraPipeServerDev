package com.verapipe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "standard_code")
public class StandardCodeEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "standard_code", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;

}
