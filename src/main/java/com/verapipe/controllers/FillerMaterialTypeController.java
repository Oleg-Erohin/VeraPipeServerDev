package com.verapipe.controllers;

import com.verapipe.dto.FillerMaterialType;
import com.verapipe.logic.FillerMaterialTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filler-material-types")
public class FillerMaterialTypeController {
    private FillerMaterialTypeLogic fillerMaterialTypeLogic;

    @Autowired
    public FillerMaterialTypeController(FillerMaterialTypeLogic fillerMaterialTypeLogic) {
        this.fillerMaterialTypeLogic = fillerMaterialTypeLogic;
    }

    @PostMapping
    public int add (@RequestBody FillerMaterialType fillerMaterialType) throws Exception {
        return this.fillerMaterialTypeLogic.add(fillerMaterialType);
    }

    @PutMapping
    public void update (@RequestBody FillerMaterialType fillerMaterialType) throws Exception {
        this.fillerMaterialTypeLogic.update(fillerMaterialType);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.fillerMaterialTypeLogic.delete(id);
    }

    @GetMapping
    public List<FillerMaterialType> getAll() throws Exception {
        return this.fillerMaterialTypeLogic.getAll();
    }

    @GetMapping("/{id}")
    public FillerMaterialType getById(@PathVariable("id") int id) throws Exception {
        return this.fillerMaterialTypeLogic.getById(id);
    }
}
