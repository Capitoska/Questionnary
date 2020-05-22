package fapi.service;


import fapi.dto.QuestionDto;

import java.util.Set;

public interface QuestionService extends DefaultService<QuestionDto> {
    Set<QuestionDto> saveAll(Set<QuestionDto> questionDtos);
}
