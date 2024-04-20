package com.verapipe.logic;

import com.verapipe.dal.IFusionProcessDal;
import com.verapipe.dto.FillerMaterialType;
import com.verapipe.dto.FusionProcess;
import com.verapipe.entities.FillerMaterialTypeEntity;
import com.verapipe.entities.FusionProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedFusionProcessId = fusionProcessEntity.getId();
        return addedFusionProcessId;
    }

    public void update(FusionProcess fusionProcess) throws Exception {
        validations(fusionProcess);
        FusionProcessEntity sentFusionProcessEntity = new FusionProcessEntity(fusionProcess);
        FusionProcessEntity receivedFusionProcessEntity;
        try {
            receivedFusionProcessEntity = this.fusionProcessDal.save(sentFusionProcessEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentFusionProcessEntity.equals(receivedFusionProcessEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isFusionProcessExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.fusionProcessDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public FusionProcess getById(int id) throws Exception {
        Optional<FusionProcessEntity> fusionProcessEntity;
        try {
            fusionProcessEntity = this.fusionProcessDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (fusionProcessEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Fusion Process not found");
        }
        FusionProcess fusionProcess = new FusionProcess(fusionProcessEntity.get());
        return fusionProcess;
    }

    public List<FusionProcess> getAll() throws Exception {
        Iterable<FusionProcessEntity> fusionProcessEntities = this.fusionProcessDal.findAll();
        List<FusionProcess> fusionProcesses = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!fusionProcessEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Fusion Processes list is empty");
        }
        // Convert Iterable to List
        for (FusionProcessEntity fusionProcessEntity : fusionProcessEntities
        ) {
            FusionProcess fusionProcess = new FusionProcess(fusionProcessEntity);
            fusionProcesses.add(fusionProcess);
        }
        return fusionProcesses;
    }


    private void validations(FusionProcess fusionProcess) throws Exception {
//      TODO Create validations
    }

    private boolean isFusionProcessExist(int id) {
        return this.fusionProcessDal.existsById(id);
    }
}
