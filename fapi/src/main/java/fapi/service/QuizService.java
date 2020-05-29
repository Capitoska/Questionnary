package fapi.service;

import fapi.dto.QuizDto;

import java.util.Optional;

public interface QuizService extends DefaultService<QuizDto> {
    Iterable<QuizDto> findByName(String name);

    public Optional<QuizDto> findByIdOrUrl(String finder);

    boolean generateUrlAddress(QuizDto quizDto);

    void update(QuizDto quizDto);
}
