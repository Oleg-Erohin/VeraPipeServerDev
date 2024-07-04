package com.verapipe.controllers;

import com.verapipe.dto.BaseMaterialType;
import com.verapipe.dto.FillerMaterialCertificate;
import com.verapipe.logic.BaseMaterialTypeLogic;
import com.verapipe.logic.FillerMaterialCertificateLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filler-material-certificates")
public class FillerMaterialCertificateController {
    private FillerMaterialCertificateLogic fillerMaterialCertificateLogic;

    @Autowired
    public FillerMaterialCertificateController(FillerMaterialCertificateLogic fillerMaterialCertificateLogic) {
        this.fillerMaterialCertificateLogic = fillerMaterialCertificateLogic;
    }

    @PostMapping
    public int add (@RequestBody FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        return this.fillerMaterialCertificateLogic.add(fillerMaterialCertificate);
    }

    @PutMapping
    public void update (@RequestBody FillerMaterialCertificate fillerMaterialCertificate) throws Exception {
        this.fillerMaterialCertificateLogic.update(fillerMaterialCertificate);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.fillerMaterialCertificateLogic.delete(id);
    }

    @GetMapping
    public List<FillerMaterialCertificate> getAll() throws Exception {
        return this.fillerMaterialCertificateLogic.getAll();
    }

    @GetMapping("/{id}")
    public FillerMaterialCertificate getById(@PathVariable("id") int id) throws Exception {
        return this.fillerMaterialCertificateLogic.getById(id);
    }
}
