package com.verapipe.controllers;

import com.verapipe.dto.Joiner;
import com.verapipe.entities.*;
import com.verapipe.logic.JoinerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/joiners")
public class JoinerController {
    private JoinerLogic joinerLogic;

    @Autowired
    public JoinerController(JoinerLogic joinerLogic) {
        this.joinerLogic = joinerLogic;
    }

    @PostMapping
    public int add (@RequestBody Joiner joiner) throws Exception {
        return this.joinerLogic.add(joiner);
    }

    @PutMapping
    public void update (@RequestBody Joiner joiner) throws Exception {
        this.joinerLogic.update(joiner);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.joinerLogic.delete(id);
    }

    @GetMapping
    public List<Joiner> getAll() throws Exception {
        return this.joinerLogic.getAll();
    }

    @GetMapping("/{id}")
    public Joiner getById(@PathVariable("id") int id) throws Exception {
        return this.joinerLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<Joiner> getJoiners(
            @RequestParam(required = false) Set<String> tagId,
            @RequestParam(required = false) Float certifiedDiameterMinMm,
            @RequestParam(required = false) Float certifiedDiameterMaxMm,
            @RequestParam(required = false) Float certifiedDiameterMinInch,
            @RequestParam(required = false) Float certifiedDiameterMaxInch,
            @RequestParam(required = false) Float maxDepositedMaterial,
            @RequestParam(required = false) Set<BaseMaterialTypeEntity> baseMaterialTypeList,
            @RequestParam(required = false) JointDesignEntity jointDesign,
            @RequestParam(required = false) FusionProcessEntity fusionProcess,
            @RequestParam(required = false) Set<JointEntity> jointsList) {

        return this.joinerLogic.findJoinersByFilters(tagId, certifiedDiameterMinMm, certifiedDiameterMaxMm, certifiedDiameterMinInch, certifiedDiameterMaxInch, maxDepositedMaterial, baseMaterialTypeList, jointDesign, fusionProcess, jointsList);
    }
}
