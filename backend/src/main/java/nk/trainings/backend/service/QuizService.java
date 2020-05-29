package nk.trainings.backend.service;

import nk.trainings.backend.entity.QuizEntity;

import java.util.Optional;

public interface QuizService extends DefaultService<QuizEntity>{
    Iterable<QuizEntity> findByName(String name);
    Iterable<QuizEntity> findAllByAuthor_Id(Long id);
    Optional<QuizEntity> findByUrlAddress(String url);
//    QuizEntity generateUrlAddress(QuizEntity quizEntity);
    QuizEntity update(QuizEntity quizEntity);
}
