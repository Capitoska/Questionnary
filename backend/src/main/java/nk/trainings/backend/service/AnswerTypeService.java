package nk.trainings.backend.service;

import nk.trainings.backend.entity.AnswerTypeEntity;

import java.util.Optional;

public interface AnswerTypeService extends DefaultService<AnswerTypeEntity> {
    Optional<AnswerTypeEntity> findByValue(String value);
}
