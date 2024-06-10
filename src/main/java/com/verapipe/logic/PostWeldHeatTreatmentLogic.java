package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPostWeldHeatTreatmentDal;
import com.verapipe.dto.PostWeldHeatTreatment;
import com.verapipe.entities.PostWeldHeatTreatmentEntity;
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
public class PostWeldHeatTreatmentLogic {
    private IPostWeldHeatTreatmentDal postWeldHeatTreatmentDal;

    @Autowired
    public PostWeldHeatTreatmentLogic(IPostWeldHeatTreatmentDal postWeldHeatTreatmentDal) {
        this.postWeldHeatTreatmentDal = postWeldHeatTreatmentDal;
    }

    public int add(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        validations(postWeldHeatTreatment);
        PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity = new PostWeldHeatTreatmentEntity(postWeldHeatTreatment);
        try {
            postWeldHeatTreatmentEntity = this.postWeldHeatTreatmentDal.save(postWeldHeatTreatmentEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
        int addedPostWeldHeatTreatmentId = postWeldHeatTreatmentEntity.getId();
        return addedPostWeldHeatTreatmentId;
    }

    public void update(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        validations(postWeldHeatTreatment);
        PostWeldHeatTreatmentEntity sentPostWeldHeatTreatmentEntity = new PostWeldHeatTreatmentEntity(postWeldHeatTreatment);
        try {
            this.postWeldHeatTreatmentDal.save(sentPostWeldHeatTreatmentEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_COULD_NOT_BE_ADDED_OR_UPDATED);
        }
    }

    public void delete(int id) throws Exception {
        if (!isPostWeldHeatTreatmentExist(id)) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_DOES_NOT_EXIST);
        }
        try {
            this.postWeldHeatTreatmentDal.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.FAILED_TO_DELETE_POST_WELD_HEAT_TREATMENT);
        }
    }

    public PostWeldHeatTreatment getById(int id) throws Exception {
        Optional<PostWeldHeatTreatmentEntity> postWeldHeatTreatmentEntity;
        try {
            postWeldHeatTreatmentEntity = this.postWeldHeatTreatmentDal.findById(id);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_COULD_NOT_BE_FOUND);
        }
        if (postWeldHeatTreatmentEntity.isEmpty()) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_DOES_NOT_EXIST);
        }
        PostWeldHeatTreatment postWeldHeatTreatment = new PostWeldHeatTreatment(postWeldHeatTreatmentEntity.get());
        return postWeldHeatTreatment;
    }

    public List<PostWeldHeatTreatment> getAll() throws Exception {
        Iterable<PostWeldHeatTreatmentEntity> postWeldHeatTreatmentEntities;
        List<PostWeldHeatTreatment> postWeldHeatTreatments = new ArrayList<>();
        try {
            postWeldHeatTreatmentEntities = this.postWeldHeatTreatmentDal.findAll();
            // Convert Iterable to List
            for (PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity : postWeldHeatTreatmentEntities
            ) {
                PostWeldHeatTreatment postWeldHeatTreatment = new PostWeldHeatTreatment(postWeldHeatTreatmentEntity);
                postWeldHeatTreatments.add(postWeldHeatTreatment);
            }
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.POST_WELD_HEAT_TREATMENT_COULD_NOT_BE_FOUND);
        }
        return postWeldHeatTreatments;
    }

    private void validations(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        validatePostWeldHeatTreatmentName(postWeldHeatTreatment.getName());
        validatePostWeldHeatTreatmentProcessSpecificationProcedure(postWeldHeatTreatment.getProcessSpecificationProcedureName());
        validatePostWeldHeatTreatmentDate(postWeldHeatTreatment.getDate());
    }

    private void validatePostWeldHeatTreatmentDate(Date date) throws Exception {
        CommonValidations.validateDateIsNotLaterThanCurrentDate(date);
    }

    private void validatePostWeldHeatTreatmentProcessSpecificationProcedure(String processSpecificationProcedureName) throws Exception {
        CommonValidations.validateIsExistInProcessSpecificationProcedures(processSpecificationProcedureName);
    }

    private void validatePostWeldHeatTreatmentName(String name) throws ApplicationException {
        CommonValidations.validateStringLength(name, Consts.resourceNameLengthMin, Consts.resourceNameLengthMax);
    }

    private boolean isPostWeldHeatTreatmentExist(int id) {
        return this.postWeldHeatTreatmentDal.existsById(id);
    }
}
