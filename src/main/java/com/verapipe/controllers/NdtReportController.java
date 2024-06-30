package com.verapipe.controllers;

import com.verapipe.dto.NdtReport;
import com.verapipe.logic.NdtReportLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ndt-report")
public class NdtReportController {
    private NdtReportLogic ndtReportLogic;

    @Autowired
    public NdtReportController(NdtReportLogic ndtReportLogic) {
        this.ndtReportLogic = ndtReportLogic;
    }

    @PostMapping
    public int add (@RequestBody NdtReport ndtReport) throws Exception {
        return this.ndtReportLogic.add(ndtReport);
    }

    @PutMapping
    public void update (@RequestBody NdtReport ndtReport) throws Exception {
        this.ndtReportLogic.update(ndtReport);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.ndtReportLogic.delete(id);
    }

    @GetMapping
    public List<NdtReport> getAll() throws Exception {
        return this.ndtReportLogic.getAll();
    }

    @GetMapping("/{id}")
    public NdtReport getById(@PathVariable("id") int id) throws Exception {
        return this.ndtReportLogic.getById(id);
    }
}
