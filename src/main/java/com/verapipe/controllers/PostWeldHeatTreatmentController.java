package com.verapipe.controllers;

import com.verapipe.dto.PostWeldHeatTreatment;
import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.logic.PostWeldHeatTreatmentLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/post-weld-heat-treatments")
public class PostWeldHeatTreatmentController {
    private PostWeldHeatTreatmentLogic postWeldHeatTreatmentLogic;

    @Autowired
    public PostWeldHeatTreatmentController(PostWeldHeatTreatmentLogic postWeldHeatTreatmentLogic) {
        this.postWeldHeatTreatmentLogic = postWeldHeatTreatmentLogic;
    }

    @PostMapping
    public int add (@RequestBody PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        return this.postWeldHeatTreatmentLogic.add(postWeldHeatTreatment);
    }

    @PutMapping
    public void update (@RequestBody PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        this.postWeldHeatTreatmentLogic.update(postWeldHeatTreatment);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.postWeldHeatTreatmentLogic.delete(id);
    }

    @GetMapping
    public List<PostWeldHeatTreatment> getAll() throws Exception {
        return this.postWeldHeatTreatmentLogic.getAll();
    }

    @GetMapping("/{id}")
    public PostWeldHeatTreatment getById(@PathVariable("id") int id) throws Exception {
        return this.postWeldHeatTreatmentLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<PostWeldHeatTreatment> getPostWeldHeatTreatments(
            @RequestParam(required = false) Set<String> names,
            @RequestParam(required = false) Set<ProcessSpecificationProcedure> processSpecificationProcedures,
            @RequestParam(required = false) Set<Date> dates) {
        return this.postWeldHeatTreatmentLogic.findPostWeldHeatTreatmentsByFilters(names, processSpecificationProcedures, dates);
    }
}
