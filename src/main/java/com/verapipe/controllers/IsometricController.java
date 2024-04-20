package com.verapipe.controllers;

import com.verapipe.dto.Isometric;
import com.verapipe.logic.IsometricLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/isometric")
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
}
