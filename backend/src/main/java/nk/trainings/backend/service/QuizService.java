package nk.trainings.backend.service;

import nk.trainings.backend.entity.QuizEntity;

public interface QuizService extends DefaultService<QuizEntity>{
    Iterable<QuizEntity> findByName(String name);
    Iterable<QuizEntity> findAllByAuthor_Id(Long id);
//    QuizEntity generateUrlAddress(QuizEntity quizEntity);
    QuizEntity update(QuizEntity quizEntity);
}
