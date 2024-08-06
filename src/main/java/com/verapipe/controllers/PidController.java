package com.verapipe.controllers;

import com.verapipe.dto.Pid;
import com.verapipe.logic.PidLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pids")
public class PidController {
    private PidLogic pidLogic;

    @Autowired
    public PidController(PidLogic pidLogic) {
        this.pidLogic = pidLogic;
    }

    @PostMapping
    public int add (@RequestBody Pid pid) throws Exception {
        return this.pidLogic.add(pid);
    }

    @PutMapping
    public void update (@RequestBody Pid pid) throws Exception {
        this.pidLogic.update(pid);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.pidLogic.delete(id);
    }

    @GetMapping
    public List<Pid> getAll() throws Exception {
        return this.pidLogic.getAll();
    }

    @GetMapping("/{id}")
    public Pid getById(@PathVariable("id") int id) throws Exception {
        return this.pidLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<Pid> getPids(
            @RequestParam(required = false) Set<String> names,
            @RequestParam(required = false) Set<String> revisions,
            @RequestParam(required = false) Set<Date> dates) {
        return this.pidLogic.findPidsByFilters(names, revisions, dates);
    }
}
