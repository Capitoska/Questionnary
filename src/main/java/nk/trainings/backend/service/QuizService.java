package nk.trainings.backend.service;

import nk.trainings.backend.entity.QuizEntity;

import java.util.Optional;

public interface QuizService {
    Iterable<QuizEntity> findALL();

    Optional<QuizEntity> findById(Long id);

    QuizEntity save(QuizEntity quizEntity);

    void deleteById(Long id);
}
