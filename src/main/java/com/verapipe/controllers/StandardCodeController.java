package com.verapipe.controllers;

import com.verapipe.dto.StandardCode;
import com.verapipe.logic.StandardCodeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standard-code")
public class StandardCodeController {
    private StandardCodeLogic standardCodeLogic;

    @Autowired
    public StandardCodeController(StandardCodeLogic standardCodeLogic) {
        this.standardCodeLogic = standardCodeLogic;
    }

    @PostMapping
    public int add (@RequestBody StandardCode standardCode) throws Exception {
        return this.standardCodeLogic.add(standardCode);
    }

    @PutMapping
    public void update (@RequestBody StandardCode standardCode) throws Exception {
        this.standardCodeLogic.update(standardCode);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.standardCodeLogic.delete(id);
    }

    @GetMapping
    public List<StandardCode> getAll() throws Exception {
        return this.standardCodeLogic.getAll();
    }

    @GetMapping("/{id}")
    public StandardCode getById(@PathVariable("id") int id) throws Exception {
        return this.standardCodeLogic.getById(id);
    }
}
