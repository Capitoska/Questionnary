package nk.trainings.backend.service;

import nk.trainings.backend.entity.QuestionEntity;

import java.util.Optional;

public interface QuestionService {
    Iterable<QuestionEntity> findALL();

    Optional<QuestionEntity> findById(Long id);

    QuestionEntity save(QuestionEntity questionEntity);

    void deleteById(Long id);
}
