package fapi.service;

import fapi.dto.AnswerTypeDto;

import java.util.Optional;

public interface AnswerTypeService extends DefaultService<AnswerTypeDto> {
    Optional<AnswerTypeDto> getAnswerTypeByValue(String value);
}
