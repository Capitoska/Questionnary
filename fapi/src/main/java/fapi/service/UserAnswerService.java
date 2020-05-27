package fapi.service;


import fapi.dto.UserAnswerDto;

import java.util.List;

public interface UserAnswerService extends DefaultService<UserAnswerDto> {
    List<UserAnswerDto> saveAll(List<UserAnswerDto> dto);
}
