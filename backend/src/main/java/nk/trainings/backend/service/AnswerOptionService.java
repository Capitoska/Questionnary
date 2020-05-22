package nk.trainings.backend.service;

import nk.trainings.backend.entity.AnswerOptionEntity;

import java.util.Optional;

public interface AnswerOptionService extends DefaultService<AnswerOptionEntity> {
    Optional<AnswerOptionEntity> findByValue(String value);
}
