package com.verapipe.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.*;
import com.verapipe.entities.NdtReportEntity;
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
            @RequestParam(required = false) Set<Integer> numbers,
            @RequestParam(required = false) Set<Pid> pids,
            @RequestParam(required = false) Set<Isometric> isometrics,
            @RequestParam(required = false) Set<String> schedules,
            @RequestParam(required = false) Set<Float> diameters,
            @RequestParam(required = false) Set<String> fittingDescriptions,
            @RequestParam(required = false) Set<BaseMaterialType> baseMaterialTypes,
            @RequestParam(required = false) Set<BaseMaterialCertificate> baseMaterialCertificates,
            @RequestParam(required = false) Set<Float> thicknesses,
            @RequestParam(required = false) Set<FillerMaterialType> fillerMaterialTypes,
            @RequestParam(required = false) Set<FillerMaterialCertificate> fillerMaterialCertificates,
            @RequestParam(required = false) Set<ProcessSpecificationProcedure> processSpecificationProcedures,
            @RequestParam(required = false) Set<Joiner> joiners,
            @RequestParam(required = false) Set<Date> dates,
            @RequestParam(required = false) Boolean isFitUpDone,
            @RequestParam(required = false) Boolean isVisualInspectionDone,
            @RequestParam(required = false) Set<NdtReportEntity> ndtReports,
            @RequestParam(required = false) Boolean isNdtPassed,
            @RequestParam(required = false) Set<Preheat> preheats,
            @RequestParam(required = false) Set<PostWeldHeatTreatment> postWeldHeatTreatments) throws JsonProcessingException {

        return this.jointLogic.findJointsByFilters(numbers, pids, isometrics, schedules, diameters, fittingDescriptions, baseMaterialTypes, baseMaterialCertificates, thicknesses, fillerMaterialTypes, fillerMaterialCertificates, processSpecificationProcedures, joiners, dates, isFitUpDone, isVisualInspectionDone, ndtReports, isNdtPassed, preheats, postWeldHeatTreatments);
    }
}
