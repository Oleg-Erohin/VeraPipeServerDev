package com.verapipe.controllers;

import com.verapipe.dto.FusionProcess;
import com.verapipe.logic.FusionProcessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fusion-processes")
public class FusionProcessController {
    private FusionProcessLogic fusionProcessLogic;

    @Autowired
    public FusionProcessController(FusionProcessLogic fusionProcessLogic) {
        this.fusionProcessLogic = fusionProcessLogic;
    }

    @PostMapping
    public int add (@RequestBody FusionProcess fusionProcess) throws Exception {
        return this.fusionProcessLogic.add(fusionProcess);
    }

    @PutMapping
    public void update (@RequestBody FusionProcess fusionProcess) throws Exception {
        this.fusionProcessLogic.update(fusionProcess);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.fusionProcessLogic.delete(id);
    }

    @GetMapping
    public List<FusionProcess> getAll() throws Exception {
        return this.fusionProcessLogic.getAll();
    }

    @GetMapping("/{id}")
    public FusionProcess getById(@PathVariable("id") int id) throws Exception {
        return this.fusionProcessLogic.getById(id);
    }
}
