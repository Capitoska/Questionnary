package fapi.service;


import fapi.dto.AnswerOptionDto;

import java.util.Optional;

public interface AnswerOptionService extends DefaultService<AnswerOptionDto> {
    Optional<AnswerOptionDto> getByValue(String value);
}
