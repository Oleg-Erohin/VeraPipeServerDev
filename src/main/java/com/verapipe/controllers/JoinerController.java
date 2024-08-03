package com.verapipe.controllers;

import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.FusionProcess;
import com.verapipe.dto.Joiner;
import com.verapipe.dto.JointDesign;
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
    public int add(@RequestBody Joiner joiner) throws Exception {
        return this.joinerLogic.add(joiner);
    }

    @PutMapping
    public void update(@RequestBody Joiner joiner) throws Exception {
        this.joinerLogic.update(joiner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
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
            @RequestParam(required = false) Set<String> tagIds,
            @RequestParam(required = false) Set<Float> certifiedDiameterMin,
            @RequestParam(required = false) Set<Float> certifiedDiameterMax,
            @RequestParam(required = false) Set<Float> maxDepositedMaterial,
            @RequestParam(required = false) Set<BaseMaterialType> baseMaterialTypes,
            @RequestParam(required = false) Set<JointDesign> jointDesigns,
            @RequestParam(required = false) Set<FusionProcess> fusionProcesses) {

        return this.joinerLogic.findJoinersByFilters(tagIds, certifiedDiameterMin, certifiedDiameterMax, maxDepositedMaterial, baseMaterialTypes, jointDesigns, fusionProcesses);
    }
}
