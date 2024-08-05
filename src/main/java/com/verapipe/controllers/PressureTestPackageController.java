package com.verapipe.controllers;

import com.verapipe.dto.Isometric;
import com.verapipe.dto.Pid;
import com.verapipe.dto.PressureTestPackage;
import com.verapipe.logic.PressureTestPackageLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pressure-test-packages")
public class PressureTestPackageController {
    private PressureTestPackageLogic pressureTestPackageLogic;

    @Autowired
    public PressureTestPackageController(PressureTestPackageLogic pressureTestPackageLogic) {
        this.pressureTestPackageLogic = pressureTestPackageLogic;
    }

    @PostMapping
    public int add (@RequestBody PressureTestPackage pressureTestPackage) throws Exception {
        return this.pressureTestPackageLogic.add(pressureTestPackage);
    }

    @PutMapping
    public void update (@RequestBody PressureTestPackage pressureTestPackage) throws Exception {
        this.pressureTestPackageLogic.update(pressureTestPackage);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.pressureTestPackageLogic.delete(id);
    }

    @GetMapping
    public List<PressureTestPackage> getAll() throws Exception {
        return this.pressureTestPackageLogic.getAll();
    }

    @GetMapping("/{id}")
    public PressureTestPackage getById(@PathVariable("id") int id) throws Exception {
        return this.pressureTestPackageLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<PressureTestPackage> getPressureTestPackages(
            @RequestParam(required = false) Set<String> names,
            @RequestParam(required = false) Set<Pid> pids,
            @RequestParam(required = false) Set<Isometric> isometrics,
            @RequestParam(required = false) Set<Date> dates) throws Exception {
        return this.pressureTestPackageLogic.findPressureTestPackagesByFilters(names, pids, isometrics, dates);
    }
}
