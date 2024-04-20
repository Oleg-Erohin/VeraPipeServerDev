package com.verapipe.controllers;

import com.verapipe.dto.PressureTestPackage;
import com.verapipe.logic.PressureTestPackageLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pressure_test_package")
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
}
