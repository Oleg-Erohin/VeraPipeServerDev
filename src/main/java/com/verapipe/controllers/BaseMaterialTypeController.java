package com.verapipe.controllers;

import com.verapipe.dto.BaseMaterialCertificate;
import com.verapipe.dto.BaseMaterialType;
import com.verapipe.logic.BaseMaterialCertificateLogic;
import com.verapipe.logic.BaseMaterialTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base-material-types")
public class BaseMaterialTypeController {
    private BaseMaterialTypeLogic baseMaterialTypeLogic;

    @Autowired
    public BaseMaterialTypeController(BaseMaterialTypeLogic baseMaterialTypeLogic) {
        this.baseMaterialTypeLogic = baseMaterialTypeLogic;
    }

    @PostMapping
    public int add (@RequestBody BaseMaterialType baseMaterialType) throws Exception {
        return this.baseMaterialTypeLogic.add(baseMaterialType);
    }

    @PutMapping
    public void update (@RequestBody BaseMaterialType baseMaterialType) throws Exception {
        this.baseMaterialTypeLogic.update(baseMaterialType);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.baseMaterialTypeLogic.delete(id);
    }

    @GetMapping
    public List<BaseMaterialType> getAll() throws Exception {
        return this.baseMaterialTypeLogic.getAll();
    }

    @GetMapping("/{id}")
    public BaseMaterialType getById(@PathVariable("id") int id) throws Exception {
        return this.baseMaterialTypeLogic.getById(id);
    }
}
