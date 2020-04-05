package nk.trainings.backend.service;

import nk.trainings.backend.entity.AnswerTypeEntity;

import java.util.Optional;

public interface AnswerTypeService {
    Iterable<AnswerTypeEntity> findALL();

    Optional<AnswerTypeEntity> findById(Long id);

    AnswerTypeEntity save(AnswerTypeEntity answerTypeEntity);

    void deleteById(Long id);
}
