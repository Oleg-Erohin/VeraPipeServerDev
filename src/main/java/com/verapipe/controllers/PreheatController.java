package com.verapipe.controllers;

import com.verapipe.dto.Preheat;
import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.logic.PreheatLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/preheats")
public class PreheatController {
    private PreheatLogic preheatLogic;

    @Autowired
    public PreheatController(PreheatLogic preheatLogic) {
        this.preheatLogic = preheatLogic;
    }

    @PostMapping
    public int add (@RequestBody Preheat preheat) throws Exception {
        return this.preheatLogic.add(preheat);
    }

    @PutMapping
    public void update (@RequestBody Preheat preheat) throws Exception {
        this.preheatLogic.update(preheat);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.preheatLogic.delete(id);
    }

    @GetMapping
    public List<Preheat> getAll() throws Exception {
        return this.preheatLogic.getAll();
    }

    @GetMapping("/{id}")
    public Preheat getById(@PathVariable("id") int id) throws Exception {
        return this.preheatLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<Preheat> getPostWeldHeatTreatments(
            @RequestParam(required = false) Set<String> names,
            @RequestParam(required = false) Set<ProcessSpecificationProcedure> processSpecificationProcedures,
            @RequestParam(required = false) Set<Date> dates) {
        return this.preheatLogic.findPreheatsByFilters(names, processSpecificationProcedures, dates);
    }
}
