package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPressureTestPackageDal;
import com.verapipe.dto.PressureTestPackage;
import com.verapipe.entities.PressureTestPackageEntity;
import com.verapipe.enums.ErrorType;
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
//        validations(pressureTestPackage);
        PressureTestPackageEntity pressureTestPackageEntity = new PressureTestPackageEntity(pressureTestPackage);
        try {
            pressureTestPackageEntity = this.pressureTestPackageDal.save(pressureTestPackageEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedPressureTestPackageId = pressureTestPackageEntity.getId();
        return addedPressureTestPackageId;
    }

    public void update(PressureTestPackage pressureTestPackage) throws Exception {
//        validations(pressureTestPackage);
        PressureTestPackageEntity sentPressureTestPackageEntity = new PressureTestPackageEntity(pressureTestPackage);
        try {
            this.pressureTestPackageDal.save(sentPressureTestPackageEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isPressureTestPackageExist(id)) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_DOES_NOT_EXIST);
        }
        try {
            this.pressureTestPackageDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_PRESSURE_TEST_PACKAGE);
        }
    }

    public PressureTestPackage getById(int id) throws Exception {
        Optional<PressureTestPackageEntity> pressureTestPackageEntity;
        try {
            pressureTestPackageEntity = this.pressureTestPackageDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_COULD_NOT_BE_FOUND);
        }
        if (pressureTestPackageEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_DOES_NOT_EXIST);
        }
        PressureTestPackage pressureTestPackage = new PressureTestPackage(pressureTestPackageEntity.get());
        return pressureTestPackage;
    }

    public List<PressureTestPackage> getAll() throws Exception {
        Iterable<PressureTestPackageEntity> pressureTestPackageEntities;
        List<PressureTestPackage> pressureTestPackages = new ArrayList<>();
        try{
            pressureTestPackageEntities = this.pressureTestPackageDal.findAll();
            // Convert Iterable to List
            for (PressureTestPackageEntity pressureTestPackageEntity : pressureTestPackageEntities
            ) {
                PressureTestPackage pressureTestPackage = new PressureTestPackage(pressureTestPackageEntity);
                pressureTestPackages.add(pressureTestPackage);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.PRESSURE_TEST_PACKAGE_COULD_NOT_BE_FOUND);
        }
        return pressureTestPackages;
    }

//    private void validations(PressureTestPackage pressureTestPackage) throws Exception {
//        validatePressureTestPackageName(pressureTestPackage.getName());
//        if (pressureTestPackage.getPidNames() != null) {
//            validatePressureTestPackagePids(pressureTestPackage.getPidNames());
//        }
//        if (pressureTestPackage.getIsometricNames() != null) {
//            validatePressureTestPackageIsometrics(pressureTestPackage.getIsometricNames());
//        }
//        if (pressureTestPackage.getCoordinatesInPidsList() != null) {
////        validatePressureTestPackageCoordinatesInPids(pressureTestPackage.getCoordinatesInPidsList());
//        }
//        if (pressureTestPackage.getDate() != null) {
//            validatePressureTestPackageDate(pressureTestPackage.getDate());
//        }
//    }

    private void validatePressureTestPackageDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
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
