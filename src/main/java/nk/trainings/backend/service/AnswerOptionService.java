package nk.trainings.backend.service;

import nk.trainings.backend.entity.AnswerOptionEntity;

import java.util.Optional;

public interface AnswerOptionService {
    Iterable<AnswerOptionEntity> findALL();

    Optional<AnswerOptionEntity> findById(Long id);

    AnswerOptionEntity save(AnswerOptionEntity answerOptionEntity);

    void deleteById(Long id);
}
