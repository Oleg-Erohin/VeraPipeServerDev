package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.INdtReportDal;
import com.verapipe.dto.NdtReport;
import com.verapipe.dto.NdtType;
import com.verapipe.entities.JointEntity;
import com.verapipe.entities.NdtReportEntity;
import com.verapipe.entities.NdtTypeEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.specifications.NdtReportSpecifications;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NdtReportLogic {
    private INdtReportDal ndtReportDal;
    private NdtTypeLogic ndtTypeLogic;
    private NdtReportSpecifications ndtReportSpecifications;

    @Autowired
    public NdtReportLogic(INdtReportDal ndtReportDal, NdtTypeLogic ndtTypeLogic, NdtReportSpecifications ndtReportSpecifications) {
        this.ndtReportDal = ndtReportDal;
        this.ndtTypeLogic = ndtTypeLogic;
        this.ndtReportSpecifications = ndtReportSpecifications;
    }

    public int add(NdtReport ndtReport) throws Exception {
        validations(ndtReport);
        NdtReportEntity ndtReportEntity = new NdtReportEntity(ndtReport);
        try {
            ndtReportEntity = this.ndtReportDal.save(ndtReportEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_REPORT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedNdtReportId = ndtReportEntity.getId();
        return addedNdtReportId;
    }

    public void update(NdtReport ndtReport) throws Exception {
        validations(ndtReport);
        NdtReportEntity sentNdtReportEntity = new NdtReportEntity(ndtReport);
        try {
            this.ndtReportDal.save(sentNdtReportEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_REPORT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isNdtReportExist(id)) {
            throw new ApplicationException(ErrorType.NDT_REPORT_DOES_NOT_EXIST);
        }
        try {
            this.ndtReportDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_NDT_REPORT);
        }
    }

    public NdtReport getById(int id) throws Exception {
        Optional<NdtReportEntity> ndtReportEntity;
        try {
            ndtReportEntity = this.ndtReportDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_REPORT_COULD_NOT_BE_FOUND);
        }
        if (ndtReportEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.NDT_REPORT_DOES_NOT_EXIST);
        }
        NdtReport ndtReport = new NdtReport(ndtReportEntity.get());
        return ndtReport;
    }

    public List<NdtReport> getAll() throws Exception {
        Iterable<NdtReportEntity> ndtReportEntities;
        List<NdtReport> ndtReports = new ArrayList<>();
        try {
            ndtReportEntities = this.ndtReportDal.findAll();
            // Convert Iterable to List
            for (NdtReportEntity ndtReportEntity : ndtReportEntities
            ) {
                NdtReport ndtReport = new NdtReport(ndtReportEntity);
                ndtReports.add(ndtReport);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.NDT_REPORT_COULD_NOT_BE_FOUND);
        }


        return ndtReports;
    }

    public List<NdtReport> findNdtReportsByFilters(String name, Date date, NdtTypeEntity ndtType, List<JointEntity> jointsList) {
        Specification<NdtReportEntity> spec = Specification
                .where(ndtReportSpecifications.hasName(name))
                .and(ndtReportSpecifications.hasDate(date))
                .and(ndtReportSpecifications.hasNdtType(ndtType))
                .and(ndtReportSpecifications.hasJointsIn(jointsList));

        List<NdtReportEntity> ndtReportEntities = this.ndtReportDal.findAll(spec);
        List<NdtReport> ndtReports = convertEntityListToDtoList(ndtReportEntities);
        return ndtReports;
    }

    private List<NdtReport> convertEntityListToDtoList(List<NdtReportEntity> ndtReportEntities) {
        List<NdtReport> ndtReports = new ArrayList<>();
        for (NdtReportEntity entity : ndtReportEntities
             ) {
            NdtReport ndtReport = new NdtReport(entity);
            ndtReports.add(ndtReport);
        }
        return ndtReports;
    }


    private void validations(NdtReport ndtReport) throws Exception {
        validateNdtReportName(ndtReport.getName());
//        validateNdtReportNdtType(ndtReport.getNdtTypeName());
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
