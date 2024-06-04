package com.verapipe.controllers;

import com.verapipe.dto.File;
import com.verapipe.logic.FileLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {
    private FileLogic fileLogic;

    @Autowired
    public FileController(FileLogic fileLogic) {
        this.fileLogic = fileLogic;
    }

    @PostMapping
    public int add (@RequestBody File file) throws Exception {
        return this.fileLogic.add(file);
    }

    @PutMapping
    public void update (@RequestBody File file) throws Exception {
        this.fileLogic.update(file);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") int id) throws Exception {
        this.fileLogic.delete(id);
    }

//    @GetMapping
//    public List<File> getAll() throws Exception {
//        return this.fileLogic.getAll();
//    }

    @GetMapping("/{id}")
    public byte[] getById(@PathVariable("id") int id) throws Exception {
        File file = this.fileLogic.getById(id);
        return file.getFile();
    }
}
