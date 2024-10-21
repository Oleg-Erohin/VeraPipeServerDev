package com.verapipe.controllers;

import com.verapipe.dto.File;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.logic.FileLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-data")
    public File getFileData(@RequestParam String fileType,
                            @RequestParam int resourceId,
                            @RequestParam(required = false) String revision) throws ApplicationException {
        return this.fileLogic.getDataByFilters(fileType, resourceId, revision);
    }
    @GetMapping("/get-file")
    public File getFile(@RequestParam String fileType,
                        @RequestParam int resourceId,
                        @RequestParam(required = false) String revision) throws ApplicationException {
        return this.fileLogic.getFileByFilters(fileType, resourceId, revision);
    }

    @GetMapping("/{id}")
    public byte[] getById(@PathVariable("id") int id) throws Exception {
        return this.fileLogic.getById(id);
    }

    @GetMapping("/get-revisions")
    public List<String> getRevisions(@RequestParam String fileType,
                                     @RequestParam int resourceId) throws ApplicationException {
        return this.fileLogic.getRevisions(fileType,resourceId);
    }

    @GetMapping("/is-exist")
    public Boolean isFileExistByResource(@RequestParam String fileType,
                        @RequestParam int resourceId) throws ApplicationException {
        return this.fileLogic.isFileExistByResource(fileType, resourceId);
    }
}
