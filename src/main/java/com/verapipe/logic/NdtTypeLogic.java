package com.verapipe.logic;

import com.verapipe.dal.INdtTypeDal;
import com.verapipe.dto.NdtType;
import com.verapipe.entities.NdtTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NdtTypeLogic {
    private INdtTypeDal ndtTypeDal;

    @Autowired
    public NdtTypeLogic(INdtTypeDal ndtTypeDal) {
        this.ndtTypeDal = ndtTypeDal;
    }

    public int add(NdtType ndtType) throws Exception {
        validations(ndtType);
        NdtTypeEntity ndtTypeEntity = new NdtTypeEntity(ndtType);
        try {
            ndtTypeEntity = this.ndtTypeDal.save(ndtTypeEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedNdtTypeId = ndtTypeEntity.getId();
        return addedNdtTypeId;
    }

    public void update(NdtType ndtType) throws Exception {
        validations(ndtType);
        NdtTypeEntity sentNdtTypeEntity = new NdtTypeEntity(ndtType);
        NdtTypeEntity receivedNdtTypeEntity;
        try {
            receivedNdtTypeEntity = this.ndtTypeDal.save(sentNdtTypeEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentNdtTypeEntity.equals(receivedNdtTypeEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isNdtTypeExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.ndtTypeDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public NdtType getById(int id) throws Exception {
        Optional<NdtTypeEntity> ndtTypeEntity;
        try {
            ndtTypeEntity = this.ndtTypeDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (ndtTypeEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Ndt Type not found");
        }
        NdtType ndtType= new NdtType(ndtTypeEntity.get());
        return ndtType;
    }

    public List<NdtType> getAll() throws Exception {
        Iterable<NdtTypeEntity> ndtTypeEntities = this.ndtTypeDal.findAll();
        List<NdtType> ndtTypes = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!ndtTypeEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Ndt Type list is empty");
        }
        // Convert Iterable to List
        for (NdtTypeEntity ndtTypeEntity : ndtTypeEntities
        ) {
            NdtType ndtType= new NdtType(ndtTypeEntity);
            ndtTypes.add(ndtType);
        }
        return ndtTypes;
    }

    private void validations(NdtType ndtType) throws Exception {
//      TODO Create validations
    }

    private boolean isNdtTypeExist(int id) {
        return this.ndtTypeDal.existsById(id);
    }
}
