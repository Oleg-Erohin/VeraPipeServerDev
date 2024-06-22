package com.verapipe.controllers;

import com.verapipe.dto.PipeWallThickness;
import com.verapipe.logic.PipeWallThicknessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pipe-wall-thickness")
public class PipeWallThicknessController {
    private PipeWallThicknessLogic pipeWallThicknessLogic;

    @Autowired
    public PipeWallThicknessController(PipeWallThicknessLogic pipeWallThicknessLogic) {
        this.pipeWallThicknessLogic = pipeWallThicknessLogic;
    }

    @GetMapping
    public List<PipeWallThickness> getAll() throws Exception {
        return this.pipeWallThicknessLogic.getAll();
    }

}
