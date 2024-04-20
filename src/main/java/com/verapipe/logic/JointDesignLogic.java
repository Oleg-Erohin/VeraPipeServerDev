package com.verapipe.logic;

import com.verapipe.dal.IJointDesignDal;
import com.verapipe.dto.JointDesign;
import com.verapipe.entities.JointDesignEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JointDesignLogic {
    private IJointDesignDal jointDesignDal;

    @Autowired
    public JointDesignLogic(IJointDesignDal jointDesignDal) {
        this.jointDesignDal = jointDesignDal;
    }

    public int add(JointDesign jointDesign) throws Exception {
        validations(jointDesign);
        JointDesignEntity jointDesignEntity = new JointDesignEntity(jointDesign);
        try {
            jointDesignEntity = this.jointDesignDal.save(jointDesignEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedJointDesignId = jointDesignEntity.getId();
        return addedJointDesignId;
    }

    public void update(JointDesign jointDesign) throws Exception {
        validations(jointDesign);
        JointDesignEntity sentJointDesignEntity = new JointDesignEntity(jointDesign);
        JointDesignEntity receivedJointDesignEntity;
        try {
            receivedJointDesignEntity = this.jointDesignDal.save(sentJointDesignEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentJointDesignEntity.equals(receivedJointDesignEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isJointDesignExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.jointDesignDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public JointDesign getById(int id) throws Exception {
        Optional<JointDesignEntity> jointDesignEntity;
        try {
            jointDesignEntity = this.jointDesignDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (jointDesignEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("Joint Design not found");
        }
        JointDesign jointDesign = new JointDesign(jointDesignEntity.get());
        return jointDesign;
    }

    public List<JointDesign> getAll() throws Exception {
        Iterable<JointDesignEntity> jointDesignEntities = this.jointDesignDal.findAll();
        List<JointDesign> jointDesigns = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!jointDesignEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("Joint Design list is empty");
        }
        // Convert Iterable to List
        for (JointDesignEntity jointDesignEntity : jointDesignEntities
        ) {
            JointDesign jointDesign = new JointDesign(jointDesignEntity);
            jointDesigns.add(jointDesign);
        }
        return jointDesigns;
    }


    private void validations(JointDesign jointDesign) throws Exception {
//      TODO Create validations
    }

    private boolean isJointDesignExist(int id) {
        return this.jointDesignDal.existsById(id);
    }
}
