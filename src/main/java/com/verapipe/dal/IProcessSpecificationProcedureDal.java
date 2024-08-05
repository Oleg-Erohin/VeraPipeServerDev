package com.verapipe.dal;

import com.verapipe.dto.ProcessSpecificationProcedure;
import com.verapipe.entities.ProcessSpecificationProcedureEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProcessSpecificationProcedureDal extends PagingAndSortingRepository<ProcessSpecificationProcedureEntity,Integer>, JpaSpecificationExecutor<ProcessSpecificationProcedureEntity> {

    ProcessSpecificationProcedure findByName(String processSpecificationProcedureName);
}
