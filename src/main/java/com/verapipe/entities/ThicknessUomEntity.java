//package com.verapipe.entities;
//
//import com.verapipe.dto.ThicknessUom;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "thickness_uom")
//public class ThicknessUomEntity {
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @Column(name = "name", unique = true, nullable = false)
//    private String name;
//
////    @OneToMany(mappedBy = "thickness_uom", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
////    private List<ProcessSpecificationProcedureEntity> processSpecificationProceduresList;
//
//    public ThicknessUomEntity() {
//    }
//
//    public ThicknessUomEntity(ThicknessUom thicknessUom) {
//        this.id = thicknessUom.getId();
//        this.name = thicknessUom.getName();
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
