package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPressureTestPackageDal;
import com.verapipe.dto.PressureTestPackage;
import com.verapipe.entities.PressureTestPackageEntity;
import com.verapipe.enums.FileTypes;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PressureTestPackageLogic {
    private IPressureTestPackageDal pressureTestPackageDal;

    @Autowired
    public PressureTestPackageLogic(IPressureTestPackageDal pressureTestPackageDal) {
        this.pressureTestPackageDal = pressureTestPackageDal;
    }

    public int add(PressureTestPackage pressureTestPackage) throws Exception {
        validations(pressureTestPackage);
        PressureTestPackageEntity pressureTestPackageEntity = new PressureTestPackageEntity(pressureTestPackage);
        try {
            pressureTestPackageEntity = this.pressureTestPackageDal.save(pressureTestPackageEntity);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedPressureTestPackageId = pressureTestPackageEntity.getId();
        return addedPressureTestPackageId;
    }

    public void update(PressureTestPackage pressureTestPackage) throws Exception {
        validations(pressureTestPackage);
        PressureTestPackageEntity sentPressureTestPackageEntity = new PressureTestPackageEntity(pressureTestPackage);
        PressureTestPackageEntity receivedPressureTestPackageEntity;
        try {
            receivedPressureTestPackageEntity = this.pressureTestPackageDal.save(sentPressureTestPackageEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentPressureTestPackageEntity.equals(receivedPressureTestPackageEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isPressureTestPackageExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.pressureTestPackageDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public PressureTestPackage getById(int id) throws Exception {
        Optional<PressureTestPackageEntity> pressureTestPackageEntity;
        try {
            pressureTestPackageEntity = this.pressureTestPackageDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (pressureTestPackageEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Pressure Test Package not found");
        }
        PressureTestPackage pressureTestPackage = new PressureTestPackage(pressureTestPackageEntity.get());
        return pressureTestPackage;
    }

    public List<PressureTestPackage> getAll() throws Exception {
        Iterable<PressureTestPackageEntity> pressureTestPackageEntities = this.pressureTestPackageDal.findAll();
        List<PressureTestPackage> pressureTestPackages = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!pressureTestPackageEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Pressure Test Package list is empty");
        }
        // Convert Iterable to List
        for (PressureTestPackageEntity pressureTestPackageEntity : pressureTestPackageEntities
        ) {
            PressureTestPackage pressureTestPackage = new PressureTestPackage(pressureTestPackageEntity);
            pressureTestPackages.add(pressureTestPackage);
        }
        return pressureTestPackages;
    }

    private void validations(PressureTestPackage pressureTestPackage) throws Exception {
        validatePressureTestPackageName(pressureTestPackage.getName());
        validatePressureTestPackagePids(pressureTestPackage.getPidNames());
        validatePressureTestPackageIsometrics(pressureTestPackage.getIsometricNames());
//        validatePressureTestPackageCoordinatesInPids(pressureTestPackage.getCoordinatesInPidsList());
        validatePressureTestPackageReportFile(pressureTestPackage.getTestReport());
        validatePressureTestPackageDate(pressureTestPackage.getDate());
    }

    private void validatePressureTestPackageDate(Date date) throws Exception {
        CommonValidations.validateDateAndTimeIsNotLaterThanCurrentDateAndTime(date);
    }

    private void validatePressureTestPackageReportFile(byte[] testReport) throws Exception {
        CommonValidations.validateFileType(testReport, FileTypes.PDF);
        CommonValidations.validateFileMaxSize(testReport);
    }

    private void validatePressureTestPackageIsometrics(List<String> isometricNames) throws Exception {
        for (String isometricName : isometricNames) {
            CommonValidations.validateIsExistInIsometrics(isometricName);
        }
    }

    private void validatePressureTestPackagePids(List<String> pidNames) throws Exception {
        for (String pidName : pidNames) {
            CommonValidations.validateIsExistInPids(pidName);
        }
    }

    private void validatePressureTestPackageName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isPressureTestPackageExist(int id) {
        return this.pressureTestPackageDal.existsById(id);
    }
}
