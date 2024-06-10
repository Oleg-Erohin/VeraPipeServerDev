package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IFusionProcessDal;
import com.verapipe.dto.FusionProcess;
import com.verapipe.entities.FusionProcessEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FusionProcessLogic {
    private IFusionProcessDal fusionProcessDal;

    @Autowired
    public FusionProcessLogic(IFusionProcessDal fusionProcessDal) {
        this.fusionProcessDal = fusionProcessDal;
    }

    public int add(FusionProcess fusionProcess) throws Exception {
        validations(fusionProcess);
        FusionProcessEntity fusionProcessEntity = new FusionProcessEntity(fusionProcess);
        try {
            fusionProcessEntity = this.fusionProcessDal.save(fusionProcessEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedFusionProcessId = fusionProcessEntity.getId();
        return addedFusionProcessId;
    }

    public void update(FusionProcess fusionProcess) throws Exception {
        validations(fusionProcess);
        FusionProcessEntity sentFusionProcessEntity = new FusionProcessEntity(fusionProcess);
        try {
            this.fusionProcessDal.save(sentFusionProcessEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isFusionProcessExist(id)) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_DOES_NOT_EXIST);
        }
        try {
            this.fusionProcessDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_FUSION_PROCESS);
        }
    }

    public FusionProcess getById(int id) throws Exception {
        Optional<FusionProcessEntity> fusionProcessEntity;
        try {
            fusionProcessEntity = this.fusionProcessDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_COULD_NOT_BE_FOUND);
        }
        if (fusionProcessEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_DOES_NOT_EXIST);
        }
        FusionProcess fusionProcess = new FusionProcess(fusionProcessEntity.get());
        return fusionProcess;
    }

    @Cacheable(cacheNames = "fusionProcessesCache", key = "#root.methodName")
    public List<FusionProcess> getAll() throws Exception {
        Iterable<FusionProcessEntity> fusionProcessEntities;
        List<FusionProcess> fusionProcesses = new ArrayList<>();
        try{
            fusionProcessEntities = this.fusionProcessDal.findAll();
            // Convert Iterable to List
            for (FusionProcessEntity fusionProcessEntity : fusionProcessEntities
            ) {
                FusionProcess fusionProcess = new FusionProcess(fusionProcessEntity);
                fusionProcesses.add(fusionProcess);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FUSION_PROCESS_COULD_NOT_BE_FOUND);
        }
        return fusionProcesses;
    }


    private void validations(FusionProcess fusionProcess) throws Exception {
        validateFusionProcessName(fusionProcess.getName());
    }

    private void validateFusionProcessName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isFusionProcessExist(int id) {
        return this.fusionProcessDal.existsById(id);
    }
}
