package com.verapipe.controllers;

import com.verapipe.dto.PostWeldHeatTreatment;
import com.verapipe.logic.PostWeldHeatTreatmentLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
