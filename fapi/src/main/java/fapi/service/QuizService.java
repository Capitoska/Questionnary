package fapi.service;

import fapi.dto.QuizDto;

public interface QuizService extends DefaultService<QuizDto>{
    Iterable<QuizDto> findByName(String name);
    Iterable<QuizDto> findAllByAuthor_Id(Long id);
    boolean generateUrlAddress(QuizDto quizDto);
    void update(QuizDto quizDto);
}
