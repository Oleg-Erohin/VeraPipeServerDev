package com.verapipe.logic;

import com.opencsv.CSVReader;
import com.verapipe.dal.IPipeWallThicknessDal;
import com.verapipe.dto.PipeWallThickness;
import com.verapipe.entities.PipeWallThicknessEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PipeWallThicknessLogic {

    private IPipeWallThicknessDal pipeWallThicknessDal;

    @Autowired
    public PipeWallThicknessLogic(IPipeWallThicknessDal pipeWallThicknessDal) {
        this.pipeWallThicknessDal = pipeWallThicknessDal;
    }

    @PostConstruct
    public void initializePipeWallThicknessTable() throws ApplicationException {
        Iterable<PipeWallThicknessEntity> pipeWallThicknessEntities = this.pipeWallThicknessDal.findAll();
        if (!pipeWallThicknessEntities.iterator().hasNext()) {
            try {
                loadCsvData();
            } catch (Exception e) {
                throw new ApplicationException(ErrorType.GENERAL_ERROR, "An error occurred while trying to load data to the pipe wall thickness table", e);
            }
        }
    }

    public void loadCsvData() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/PipeWallThicknessData.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));

        String[] line;
        reader.readNext(); // skip header
        while ((line = reader.readNext()) != null) {
            PipeWallThicknessEntity entity = new PipeWallThicknessEntity();
            entity.setNominalDiameterInch(line[0]);
            entity.setOdInch(parseNullableFloat(line[1]));
            entity.setOdMm(parseNullableFloat(line[2]));
            entity.setSch10(parseNullableFloat(line[3]));
            entity.setSch20(parseNullableFloat(line[4]));
            entity.setSch30(parseNullableFloat(line[5]));
            entity.setSchStd(parseNullableFloat(line[6]));
            entity.setSch40(parseNullableFloat(line[7]));
            entity.setSch60(parseNullableFloat(line[8]));
            entity.setSchXs(parseNullableFloat(line[9]));
            entity.setSch80(parseNullableFloat(line[10]));
            entity.setSch100(parseNullableFloat(line[11]));
            entity.setSch120(parseNullableFloat(line[12]));
            entity.setSch140(parseNullableFloat(line[13]));
            entity.setSch160(parseNullableFloat(line[14]));
            entity.setSchXxs(parseNullableFloat(line[15]));
            entity.setSch5S(parseNullableFloat(line[16]));
            entity.setSch10S(parseNullableFloat(line[17]));
            entity.setSch40S(parseNullableFloat(line[18]));
            entity.setSch80S(parseNullableFloat(line[19]));

            pipeWallThicknessDal.save(entity);
        }
    }

    private Float parseNullableFloat(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return Float.valueOf(value);
    }

    @Cacheable(cacheNames = "pipeWallThicknessCache", key = "#root.methodName")
    public List<PipeWallThickness> getAll() throws Exception {
        Iterable<PipeWallThicknessEntity> pipeWallThicknessEntities;
        List<PipeWallThickness> pipeWallThicknesses = new ArrayList<>();
        try{
            pipeWallThicknessEntities = this.pipeWallThicknessDal.findAll();
            // Convert Iterable to List
            for (PipeWallThicknessEntity pipeWallThicknessEntity : pipeWallThicknessEntities
            ) {
                PipeWallThickness pipeWallThickness = new PipeWallThickness(pipeWallThicknessEntity);
                pipeWallThicknesses.add(pipeWallThickness);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PIPE_WALL_THICKNESS_COULD_NOT_BE_FOUND);
        }
        return pipeWallThicknesses;
    }

}
