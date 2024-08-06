package com.verapipe.dal;

import com.verapipe.entities.PostWeldHeatTreatmentEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPostWeldHeatTreatmentDal extends PagingAndSortingRepository<PostWeldHeatTreatmentEntity,Integer>, JpaSpecificationExecutor<PostWeldHeatTreatmentEntity> {

}
