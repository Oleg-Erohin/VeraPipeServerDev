package com.verapipe.controllers;

import com.verapipe.dto.NdtType;
import com.verapipe.logic.NdtTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ndt_type")
public class NdtTypeController {
    private NdtTypeLogic ndtTypeLogic;

    @Autowired
    public NdtTypeController(NdtTypeLogic ndtTypeLogic) {
        this.ndtTypeLogic = ndtTypeLogic;
    }

    @PostMapping
    public int add (@RequestBody NdtType ndtType) throws Exception {
        return this.ndtTypeLogic.add(ndtType);
    }

    @PutMapping
    public void update (@RequestBody NdtType ndtType) throws Exception {
        this.ndtTypeLogic.update(ndtType);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.ndtTypeLogic.delete(id);
    }

    @GetMapping
    public List<NdtType> getAll() throws Exception {
        return this.ndtTypeLogic.getAll();
    }

    @GetMapping("/{id}")
    public NdtType getById(@PathVariable("id") int id) throws Exception {
        return this.ndtTypeLogic.getById(id);
    }
}
