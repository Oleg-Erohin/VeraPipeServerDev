package com.verapipe.controllers;

import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.logic.ProcessSpecificationProcedureLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process_specification_procedure")
public class ProcessSpecificationProcedureController {
    private ProcessSpecificationProcedureLogic processSpecificationProcedureLogic;

    @Autowired
    public ProcessSpecificationProcedureController(ProcessSpecificationProcedureLogic processSpecificationProcedureLogic) {
        this.processSpecificationProcedureLogic = processSpecificationProcedureLogic;
    }

    @PostMapping
    public int add (@RequestBody ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        return this.processSpecificationProcedureLogic.add(processSpecificationProcedure);
    }

    @PutMapping
    public void update (@RequestBody ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        this.processSpecificationProcedureLogic.update(processSpecificationProcedure);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.processSpecificationProcedureLogic.delete(id);
    }

    @GetMapping
    public List<ProcessSpecificationProcedure> getAll() throws Exception {
        return this.processSpecificationProcedureLogic.getAll();
    }

    @GetMapping("/{id}")
    public ProcessSpecificationProcedure getById(@PathVariable("id") int id) throws Exception {
        return this.processSpecificationProcedureLogic.getById(id);
    }
}
