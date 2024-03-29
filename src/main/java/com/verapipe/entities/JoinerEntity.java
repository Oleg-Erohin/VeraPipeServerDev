package com.verapipe.entities;

import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.FusionProcess;
import com.verapipe.dto.JointDesign;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "joiner")
public class JoinerEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "tag_id", unique = true, nullable = false)
    private String tagId;
    @Column(name = "certificate", nullable = false)
    private byte[] certificate;
    @Column(name = "certified_diameter_min_mm")
    private Float certifiedDiameterMinMm;
    @Column(name = "certified_diameter_max_mm")
    private Float certifiedDiameterMaxMm;
    @Column(name = "certified_diameter_min_inch")
    private Float certifiedDiameterMinInch;
    @Column(name = "certified_diameter_max_inch")
    private Float certifiedDiameterMaxInch;
    @Column(name = "max_deposited_material")
    private Float maxDepositedMaterial;
    @ManyToMany
    private BaseMaterialType baseMaterialType1;
    @ManyToMany
    private BaseMaterialType baseMaterialType2;
    @ManyToOne
    private JointDesign jointDesign;
    @ManyToOne
    private FusionProcess fusionProcess;
    @ManyToMany(mappedBy = "joiner", fetch = FetchType.LAZY)
    private List<JointEntity> jointsList;
}
