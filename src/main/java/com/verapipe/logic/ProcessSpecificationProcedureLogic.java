package com.verapipe.logic;

import com.verapipe.dal.IProcessSpecificationProcedureDal;
import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessSpecificationProcedureLogic {
    private IProcessSpecificationProcedureDal processSpecificationProcedureDal;

    @Autowired
    public ProcessSpecificationProcedureLogic(IProcessSpecificationProcedureDal processSpecificationProcedureDal) {
        this.processSpecificationProcedureDal = processSpecificationProcedureDal;
    }

    public int add(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity processSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.save(processSpecificationProcedureEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedProcessSpecificationProcedureId = processSpecificationProcedureEntity.getId();
        return addedProcessSpecificationProcedureId;
    }

    public void update(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
        validations(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity sentProcessSpecificationProcedureEntity = new ProcessSpecificationProcedureEntity(processSpecificationProcedure);
        ProcessSpecificationProcedureEntity receivedProcessSpecificationProcedureEntity;
        try {
            receivedProcessSpecificationProcedureEntity = this.processSpecificationProcedureDal.save(sentProcessSpecificationProcedureEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentProcessSpecificationProcedureEntity.equals(receivedProcessSpecificationProcedureEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isProcessSpecificationProcedureExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.processSpecificationProcedureDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public ProcessSpecificationProcedure getById(int id) throws Exception {
        Optional<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntity;
        try {
            processSpecificationProcedureEntity = this.processSpecificationProcedureDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (processSpecificationProcedureEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Process Specification Procedure not found");
        }
        ProcessSpecificationProcedure processSpecificationProcedure = new ProcessSpecificationProcedure(processSpecificationProcedureEntity.get());
        return processSpecificationProcedure;
    }

    public List<ProcessSpecificationProcedure> getAll() throws Exception {
        Iterable<ProcessSpecificationProcedureEntity> processSpecificationProcedureEntities= this.processSpecificationProcedureDal.findAll();
        List<ProcessSpecificationProcedure> processSpecificationProcedures = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!processSpecificationProcedureEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Process Specification Procedure list is empty");
        }
        // Convert Iterable to List
        for (ProcessSpecificationProcedureEntity processSpecificationProcedureEntity: processSpecificationProcedureEntities
        ) {
            ProcessSpecificationProcedure processSpecificationProcedure= new ProcessSpecificationProcedure(processSpecificationProcedureEntity);
            processSpecificationProcedures.add(processSpecificationProcedure);
        }
        return processSpecificationProcedures;
    }

    private void validations(ProcessSpecificationProcedure processSpecificationProcedure) throws Exception {
//      TODO Create validations
    }

    private boolean isProcessSpecificationProcedureExist(int id) {
        return this.processSpecificationProcedureDal.existsById(id);
    }
}
