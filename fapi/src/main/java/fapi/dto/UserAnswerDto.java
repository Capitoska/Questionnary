package fapi.dto;

import lombok.Data;

@Data
public class UserAnswerDto {
    private Long id;
    private UserDto user;
    private AnswerOptionDto answer;

}
