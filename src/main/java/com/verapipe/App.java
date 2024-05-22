package com.verapipe;

import com.verapipe.exceptions.ApplicationException;
import com.verapipe.logic.PipeWallThicknessLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class App {
    public static void main(String[] args) throws ApplicationException {
        SpringApplication.run(App.class, args);
//        initializeDataInDb();
    }

    private static void initializeDataInDb() throws ApplicationException {
        PipeWallThicknessLogic pipeWallThicknessLogic = new PipeWallThicknessLogic();
        pipeWallThicknessLogic.initializePipeWallThicknessTable();
    }
}
