package fapi.entity;

import lombok.Data;

@Data
public class UserAnswerEntity {
    private Long id;
    private UserEntity user;
    private AnswerOptionEntity answer;

}
