package com.verapipe.logic;

import com.opencsv.CSVReader;
import com.verapipe.dal.IPipeWallThicknessDal;
import com.verapipe.entities.PipeWallThicknessEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;

@Service
public class PipeWallThicknessLogic {

    @Autowired
    private IPipeWallThicknessDal pipeWallThicknessDal;

    @PostConstruct
    public void initializePipeWallThicknessTable() throws ApplicationException {
        try {
            loadCsvData();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.GENERAL_ERROR, "An error occurred while trying to load data to the pipe wall thickness table", e);
        }
    }

    public void loadCsvData() throws Exception {
//        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/com/verapipe/utils/PipeWallThicknessTable.csv"))) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream("/PipeWallThicknessTable.csv")))) {
            String[] line;
            reader.readNext(); // skip header
            while ((line = reader.readNext()) != null) {
                PipeWallThicknessEntity entity = new PipeWallThicknessEntity();
                entity.setNominalDiameterInch(line[0]);
                entity.setOdInch(Float.parseFloat(line[1]));
                entity.setOdMm(Float.parseFloat(line[2]));
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
    }

    private Float parseNullableFloat(String value) {
        return (value == null || value.isEmpty()) ? null : Float.parseFloat(value);
    }
}
