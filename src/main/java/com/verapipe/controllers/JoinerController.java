package com.verapipe.controllers;

import com.verapipe.dto.Joiner;
import com.verapipe.logic.JoinerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joiners")
public class JoinerController {
    private JoinerLogic joinerLogic;

    @Autowired
    public JoinerController(JoinerLogic joinerLogic) {
        this.joinerLogic = joinerLogic;
    }

    @PostMapping
    public int add (@RequestBody Joiner joiner) throws Exception {
        return this.joinerLogic.add(joiner);
    }

    @PutMapping
    public void update (@RequestBody Joiner joiner) throws Exception {
        this.joinerLogic.update(joiner);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.joinerLogic.delete(id);
    }

    @GetMapping
    public List<Joiner> getAll() throws Exception {
        return this.joinerLogic.getAll();
    }

    @GetMapping("/{id}")
    public Joiner getById(@PathVariable("id") int id) throws Exception {
        return this.joinerLogic.getById(id);
    }
}
