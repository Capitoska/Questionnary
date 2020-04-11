package fapi.entity;

import lombok.Data;

import java.util.Set;

@Data
public class QuestionEntity {

    private Long id;
    private String text;
    private AnswerTypeEntity answerType;
    private Set<AnswerOptionEntity> rightAnswer;
    private Set<AnswerOptionEntity> possibleAnswer;
}
