package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IPostWeldHeatTreatmentDal;
import com.verapipe.dto.PostWeldHeatTreatment;
import com.verapipe.entities.PostWeldHeatTreatmentEntity;
import com.verapipe.exceptions.ApplicationException;
import com.verapipe.utils.CommonValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedPostWeldHeatTreatmentId = postWeldHeatTreatmentEntity.getId();
        return addedPostWeldHeatTreatmentId;
    }

    public void update(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        validations(postWeldHeatTreatment);
        PostWeldHeatTreatmentEntity sentPostWeldHeatTreatmentEntity = new PostWeldHeatTreatmentEntity(postWeldHeatTreatment);
        PostWeldHeatTreatmentEntity receivedPostWeldHeatTreatmentEntity;
        try {
            receivedPostWeldHeatTreatmentEntity = this.postWeldHeatTreatmentDal.save(sentPostWeldHeatTreatmentEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentPostWeldHeatTreatmentEntity.equals(receivedPostWeldHeatTreatmentEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isPostWeldHeatTreatmentExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.postWeldHeatTreatmentDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public PostWeldHeatTreatment getById(int id) throws Exception {
        Optional<PostWeldHeatTreatmentEntity> postWeldHeatTreatmentEntity;
        try {
            postWeldHeatTreatmentEntity = this.postWeldHeatTreatmentDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (postWeldHeatTreatmentEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Post Weld Heat Treatment not found");
        }
        PostWeldHeatTreatment postWeldHeatTreatment= new PostWeldHeatTreatment(postWeldHeatTreatmentEntity.get());
        return postWeldHeatTreatment;
    }

    public List<PostWeldHeatTreatment> getAll() throws Exception {
        Iterable<PostWeldHeatTreatmentEntity> postWeldHeatTreatmentEntities= this.postWeldHeatTreatmentDal.findAll();
        List<PostWeldHeatTreatment> postWeldHeatTreatments = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!postWeldHeatTreatmentEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Post Weld Heat Treatment list is empty");
        }
        // Convert Iterable to List
        for (PostWeldHeatTreatmentEntity postWeldHeatTreatmentEntity: postWeldHeatTreatmentEntities
        ) {
            PostWeldHeatTreatment postWeldHeatTreatment= new PostWeldHeatTreatment(postWeldHeatTreatmentEntity);
            postWeldHeatTreatments.add(postWeldHeatTreatment);
        }
        return postWeldHeatTreatments;
    }

    private void validations(PostWeldHeatTreatment postWeldHeatTreatment) throws Exception {
        validatePostWeldHeatTreatmentName(postWeldHeatTreatment.getName());
        validatePostWeldHeatTreatmentProcessSpecificationProcedure(postWeldHeatTreatment.getProcessSpecificationProcedureName());
        validatePostWeldHeatTreatmentFile(postWeldHeatTreatment.getFile());
//        validatePostWeldHeatTreatmentDate(postWeldHeatTreatment.getDate());
    }

    private void validatePostWeldHeatTreatmentFile(byte[] file) throws Exception {
        CommonValidations.validateFileMaxSize(file);
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
