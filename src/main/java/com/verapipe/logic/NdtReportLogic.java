package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.INdtReportDal;
import com.verapipe.dto.NdtReport;
import com.verapipe.dto.NdtType;
import com.verapipe.entities.NdtReportEntity;
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
public class NdtReportLogic {
    private INdtReportDal ndtReportDal;
    private NdtTypeLogic ndtTypeLogic;

    @Autowired
    public NdtReportLogic(INdtReportDal ndtReportDal, NdtTypeLogic ndtTypeLogic) {
        this.ndtReportDal = ndtReportDal;
        this.ndtTypeLogic = ndtTypeLogic;
    }

    public int add(NdtReport ndtReport) throws Exception {
        validations(ndtReport);
        NdtReportEntity ndtReportEntity = new NdtReportEntity(ndtReport);
        try {
            ndtReportEntity = this.ndtReportDal.save(ndtReportEntity);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedNdtReportId = ndtReportEntity.getId();
        return addedNdtReportId;
    }

    public void update(NdtReport ndtReport) throws Exception {
        validations(ndtReport);
        NdtReportEntity sentNdtReportEntity = new NdtReportEntity(ndtReport);
        NdtReportEntity receivedNdtReportEntity;
        try {
            receivedNdtReportEntity = this.ndtReportDal.save(sentNdtReportEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentNdtReportEntity.equals(receivedNdtReportEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isNdtReportExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.ndtReportDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public NdtReport getById(int id) throws Exception {
        Optional<NdtReportEntity> ndtReportEntity;
        try {
            ndtReportEntity = this.ndtReportDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (ndtReportEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Ndt Report not found");
        }
        NdtReport ndtReport = new NdtReport(ndtReportEntity.get());
        return ndtReport;
    }

    public List<NdtReport> getAll() throws Exception {
        Iterable<NdtReportEntity> ndtReportEntities = this.ndtReportDal.findAll();
        List<NdtReport> ndtReports = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!ndtReportEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Ndt Report list is empty");
        }
        // Convert Iterable to List
        for (NdtReportEntity ndtReportEntity : ndtReportEntities
        ) {
            NdtReport ndtReport = new NdtReport(ndtReportEntity);
            ndtReports.add(ndtReport);
        }
        return ndtReports;
    }


    private void validations(NdtReport ndtReport) throws Exception {
        validateNdtReportName(ndtReport.getName());
        validateNdtReportNdtType(ndtReport.getNdtTypeName());
        validateNdtReportDate(ndtReport.getDate());
    }

    private void validateNdtReportDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validateNdtReportNdtType(String ndtTypeName) throws Exception {
        List<NdtType> ndtTypes =  ndtTypeLogic.getAll();

        for (NdtType ndtType : ndtTypes){
            if (ndtType.getName().equals(ndtTypeName)){
                return;
            }
        }
        throw new ApplicationException(ErrorType.NDT_TYPE_DOES_NOT_EXIST);
    }

    private void validateNdtReportName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isNdtReportExist(int id) {
        return this.ndtReportDal.existsById(id);
    }
}
