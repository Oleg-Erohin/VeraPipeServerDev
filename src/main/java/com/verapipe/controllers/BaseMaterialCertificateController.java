package com.verapipe.controllers;

import com.verapipe.dto.BaseMaterialCertificate;
import com.verapipe.logic.BaseMaterialCertificateLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base-material-certificates")
public class BaseMaterialCertificateController {
    private BaseMaterialCertificateLogic baseMaterialCertificateLogic;

    @Autowired
    public BaseMaterialCertificateController(BaseMaterialCertificateLogic baseMaterialCertificateLogic) {
        this.baseMaterialCertificateLogic = baseMaterialCertificateLogic;
    }

    @PostMapping
    public int add(@RequestBody BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        return this.baseMaterialCertificateLogic.add(baseMaterialCertificate);
    }

    @PutMapping
    public void update(@RequestBody BaseMaterialCertificate baseMaterialCertificate) throws Exception {
        this.baseMaterialCertificateLogic.update(baseMaterialCertificate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
        this.baseMaterialCertificateLogic.delete(id);
    }

    @GetMapping
    public List<BaseMaterialCertificate> getAll() throws Exception {
        return this.baseMaterialCertificateLogic.getAll();
    }

    @GetMapping("/{id}")
    public BaseMaterialCertificate getById(@PathVariable("id") int id) throws Exception {
        return this.baseMaterialCertificateLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public List<BaseMaterialCertificate> getBaseMaterialCertificates(
            @RequestParam(required = false) List<String> heatNum,
            @RequestParam(required = false) List<String> lotNum,
            @RequestParam(required = false) List<String> materialTypeName) {

        return this.baseMaterialCertificateLogic.findCertificatesByFilters(heatNum, lotNum, materialTypeName);
    }
}
