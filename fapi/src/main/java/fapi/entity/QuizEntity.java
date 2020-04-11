package fapi.entity;

import lombok.Data;

import java.util.Set;

@Data
public class QuizEntity {

    private Long id;
    private String name;
    private UserEntity author;
    private Set<QuestionEntity> questions;
    private Boolean isOpen;
}
