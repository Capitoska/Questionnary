package fapi.service;

import fapi.dto.QuizDto;

public interface QuizService extends DefaultService<QuizDto> {
    Iterable<QuizDto> findByName(String name);

    boolean generateUrlAddress(QuizDto quizDto);

    void update(QuizDto quizDto);
}
