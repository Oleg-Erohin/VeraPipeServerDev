package com.verapipe.dal;

import com.verapipe.entities.PipeWallThicknessEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPipeWallThicknessDal extends CrudRepository<PipeWallThicknessEntity, Integer> {
}