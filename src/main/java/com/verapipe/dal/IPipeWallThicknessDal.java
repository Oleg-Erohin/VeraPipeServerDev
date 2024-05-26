package com.verapipe.dal;

import com.verapipe.entities.PipeWallThicknessEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPipeWallThicknessDal extends PagingAndSortingRepository<PipeWallThicknessEntity, Integer> {
}