package com.verapipe.controllers;

import com.verapipe.dto.JointDesign;
import com.verapipe.logic.JointDesignLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joint_design")
public class JointDesignController {
    private JointDesignLogic jointDesignLogic;

    @Autowired
    public JointDesignController(JointDesignLogic jointDesignLogic) {
        this.jointDesignLogic = jointDesignLogic;
    }

    @PostMapping
    public int add (@RequestBody JointDesign jointDesign) throws Exception {
        return this.jointDesignLogic.add(jointDesign);
    }

    @PutMapping
    public void update (@RequestBody JointDesign jointDesign) throws Exception {
        this.jointDesignLogic.update(jointDesign);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.jointDesignLogic.delete(id);
    }

    @GetMapping
    public List<JointDesign> getAll() throws Exception {
        return this.jointDesignLogic.getAll();
    }

    @GetMapping("/{id}")
    public JointDesign getById(@PathVariable("id") int id) throws Exception {
        return this.jointDesignLogic.getById(id);
    }
}
