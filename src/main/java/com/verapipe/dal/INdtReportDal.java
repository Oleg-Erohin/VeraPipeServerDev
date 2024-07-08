package com.verapipe.dal;

import com.verapipe.entities.NdtReportEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INdtReportDal extends PagingAndSortingRepository<NdtReportEntity,Integer>, JpaSpecificationExecutor<NdtReportEntity> {

}
