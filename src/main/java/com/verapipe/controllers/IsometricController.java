package com.verapipe.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verapipe.dto.Isometric;
import com.verapipe.entities.JointEntity;
import com.verapipe.entities.PidEntity;
import com.verapipe.entities.PressureTestPackageEntity;
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
            @RequestParam(required = false) List<String> name,
            @RequestParam(required = false) List<String> revision,
            @RequestParam(required = false) List<Date> date,
            @RequestParam(required = false) List<Integer> sheets,
            @RequestParam(required = false) List<String> coordinatesInPid,
            @RequestParam(required = false) Boolean isApproved,
            @RequestParam(required = false) List<String> comments,
            @RequestParam(required = false) Set<PidEntity> pidsList,
            @RequestParam(required = false) List<JointEntity> jointsList,
            @RequestParam(required = false) Set<PressureTestPackageEntity> testPacksList) throws JsonProcessingException {

        return isometricLogic.findIsometricsByFilters(name, revision, date, sheets, coordinatesInPid, isApproved, comments, pidsList, jointsList, testPacksList);
    }
}
