package com.verapipe.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Joint;
import com.verapipe.entities.*;
import com.verapipe.enums.UnitOfMeasure;
import com.verapipe.logic.JointLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/joints")
public class JointController {
    private JointLogic jointLogic;

    @Autowired
    public JointController(JointLogic jointLogic) {
        this.jointLogic = jointLogic;
    }

    @PostMapping
    public int add (@RequestBody Joint joint) throws Exception {
        return this.jointLogic.add(joint);
    }

    @PutMapping
    public void update (@RequestBody Joint joint) throws Exception {
        this.jointLogic.update(joint);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.jointLogic.delete(id);
    }

    @GetMapping
    public List<Joint> getAll() throws Exception {
        return this.jointLogic.getAll();
    }

    @GetMapping("/{id}")
    public Joint getById(@PathVariable("id") int id) throws Exception {
        return this.jointLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<Joint> getJoints(
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) String coordinatesOnIsometric,
            @RequestParam(required = false) PidEntity pid,
            @RequestParam(required = false) IsometricEntity isometric,
            @RequestParam(required = false) Integer sheetOnIsometric,
            @RequestParam(required = false) UnitOfMeasure uom,
            @RequestParam(required = false) String schedule,
            @RequestParam(required = false) Float diameter,
            @RequestParam(required = false) String fittingDescription1,
            @RequestParam(required = false) String comments,
            @RequestParam(required = false) String fittingDescription2,
            @RequestParam(required = false) Set<BaseMaterialTypeEntity> baseMaterialTypeList,
            @RequestParam(required = false) Set<BaseMaterialCertificateEntity> baseMaterialCertificateList,
            @RequestParam(required = false) Float thickness,
            @RequestParam(required = false) Set<FillerMaterialTypeEntity> fillerMaterialTypeList,
            @RequestParam(required = false) Set<FillerMaterialCertificateEntity> fillerMaterialCertificateList,
            @RequestParam(required = false) ProcessSpecificationProcedureEntity processSpecificationProcedure,
            @RequestParam(required = false) Set<JoinerEntity> joinersList,
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) Boolean isFitUpDone,
            @RequestParam(required = false) Boolean isVisualInspectionDone,
            @RequestParam(required = false) NdtReportEntity ndtReport,
            @RequestParam(required = false) Boolean isNdtPassed,
            @RequestParam(required = false) PreheatEntity preheat,
            @RequestParam(required = false) PostWeldHeatTreatmentEntity postWeldHeatTreatment) throws JsonProcessingException {

        return this.jointLogic.findJointsByFilters(number, coordinatesOnIsometric, pid, isometric, sheetOnIsometric, uom, schedule, diameter, fittingDescription1, comments, fittingDescription2, baseMaterialTypeList, baseMaterialCertificateList, thickness, fillerMaterialTypeList, fillerMaterialCertificateList, processSpecificationProcedure, joinersList, date, isFitUpDone, isVisualInspectionDone, ndtReport, isNdtPassed, preheat, postWeldHeatTreatment);
    }
}
