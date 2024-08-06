package com.verapipe.controllers;

import com.verapipe.dto.File;
import com.verapipe.logic.FileLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {
    private FileLogic fileLogic;

    @Autowired
    public FileController(FileLogic fileLogic) {
        this.fileLogic = fileLogic;
    }

    @PostMapping
    public int add(@RequestBody File file) throws Exception {
        System.out.println();
        return this.fileLogic.add(file);
    }

    @PutMapping
    public void update(@RequestBody File file) throws Exception {
        this.fileLogic.update(file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
        this.fileLogic.delete(id);
    }
    @GetMapping
    public File get(@RequestParam String fileType,
                    @RequestParam int resourceId,
                    @RequestParam(required = false) String revision) {
        System.out.println();
        return this.fileLogic.getByFilters(fileType, resourceId, revision);
    }
    @GetMapping("/{id}")
    public byte[] getById(@PathVariable("id") int id) throws Exception {
        return this.fileLogic.getById(id);
    }
}
