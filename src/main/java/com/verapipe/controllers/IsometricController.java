package com.verapipe.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.logic.IsometricLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/isometrics")
public class IsometricController {
    private IsometricLogic isometricLogic;

    @Autowired
    public IsometricController(IsometricLogic isometricLogic) {
        this.isometricLogic = isometricLogic;
    }

    @PostMapping
    public int add (@RequestBody Isometric isometric) throws Exception {
        return this.isometricLogic.add(isometric);
    }

    @PutMapping
    public void update (@RequestBody Isometric isometric) throws Exception {
        this.isometricLogic.update(isometric);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.isometricLogic.delete(id);
    }

    @GetMapping
    public List<Isometric> getAll() throws Exception {
        return this.isometricLogic.getAll();
    }

    @GetMapping("/{id}")
    public Isometric getById(@PathVariable("id") int id) throws Exception {
        return this.isometricLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<Isometric> getIsometrics(
            @RequestParam(required = false) List<String> names,
            @RequestParam(required = false) List<String> revisions,
            @RequestParam(required = false) List<Date> dates,
            @RequestParam(required = false) Boolean isApproved,
            @RequestParam(required = false) Set<Pid> pids) throws JsonProcessingException {

        return isometricLogic.findIsometricsByFilters(names, revisions, dates, isApproved, pids);
    }
}
