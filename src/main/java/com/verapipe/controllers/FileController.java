package com.verapipe.controllers;

import com.verapipe.dto.File;
import com.verapipe.enums.FileType;
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

    @GetMapping("/{id}")
    public byte[] getById(@PathVariable("id") int id) throws Exception {
        return this.fileLogic.getById(id);
    }

    @GetMapping("/by-filters")
    public File getFile(@RequestParam FileType fileType, @RequestParam String resourceName, @RequestParam String revision) {
        return this.fileLogic.getByFilters(fileType, resourceName, revision);
    }
}
