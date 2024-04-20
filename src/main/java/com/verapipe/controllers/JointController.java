package com.verapipe.controllers;

import com.verapipe.dto.Joint;
import com.verapipe.logic.JointLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joint")
public class JointController {
    private JointLogic jointLogic;

    @Autowired
    public JointController(JointLogic jointLogic) {
        this.jointLogic = jointLogic;
    }

    @PostMapping
    public int add (@RequestBody Joint joint) throws Exception {
        return this.jointLogic.add(joint);
    }

    @PutMapping
    public void update (@RequestBody Joint joint) throws Exception {
        this.jointLogic.update(joint);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.jointLogic.delete(id);
    }

    @GetMapping
    public List<Joint> getAll() throws Exception {
        return this.jointLogic.getAll();
    }

    @GetMapping("/{id}")
    public Joint getById(@PathVariable("id") int id) throws Exception {
        return this.jointLogic.getById(id);
    }
}
