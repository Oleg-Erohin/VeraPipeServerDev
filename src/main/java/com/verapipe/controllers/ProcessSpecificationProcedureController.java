package com.verapipe.controllers;

import com.verapipe.dto.*;
import com.verapipe.enums.UnitOfMeasure;
import com.verapipe.logic.ProcessSpecificationProcedureLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/process-specification-procedures")
public class ProcessSpecificationProcedureController {
    private ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;

    @Autowired
    public ProcessSpecificationProcedureController(ProcessSpecificationProcedureLogic processSpecificationProcedureLogic) {
        this.processSpecificationProcedureLogic = processSpecificationProcedureLogic;
    }

    @PostMapping
    public int add (@RequestBody ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        return this.processSpecificationProcedureLogic.add(processSpecificationProcedure);
    }

    @PutMapping
    public void update (@RequestBody ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        this.processSpecificationProcedureLogic.update(processSpecificationProcedure);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.processSpecificationProcedureLogic.delete(id);
    }

    @GetMapping
    public List<ProcessSpecificationProcedure> getAll() throws Exception {
        return this.processSpecificationProcedureLogic.getAll();
    }

    @GetMapping("/{id}")
    public ProcessSpecificationProcedure getById(@PathVariable("id") int id) throws Exception {
        return this.processSpecificationProcedureLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<ProcessSpecificationProcedure> getProcessSpecificationProcedures(
            @RequestParam(required = false) Set<String> names,
            @RequestParam(required = false)  Set<JointDesign> jointDesigns,
            @RequestParam(required = false) Set<BaseMaterialType> baseMaterialTypes,
            @RequestParam(required = false) Set<FusionProcess> fusionProcesses,
            @RequestParam(required = false) Set<FillerMaterialType> fillerMaterialTypes,
            @RequestParam(required = false) Set<StandardCode> standardCodes,
            @RequestParam(required = false) Boolean isPreheatRequired,
            @RequestParam(required = false) Boolean isPostWeldHeatTreatmentRequired,
            @RequestParam(required = false) Set<UnitOfMeasure> unitsOfMeasure,
            @RequestParam(required = false) Set<Float> minDiameters,
            @RequestParam(required = false) Set<Float> maxDiameters,
            @RequestParam(required = false) Set<Float> minThicknesses,
            @RequestParam(required = false) Set<Float> maxThicknesses) throws Exception {
        return this.processSpecificationProcedureLogic.findProcessSpecificationProceduresByFilters(names, jointDesigns, baseMaterialTypes, fusionProcesses, fillerMaterialTypes, standardCodes, isPreheatRequired, isPostWeldHeatTreatmentRequired, unitsOfMeasure, minDiameters, maxDiameters, minThicknesses, maxThicknesses);
    }
}
