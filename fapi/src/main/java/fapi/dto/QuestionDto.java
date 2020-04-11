package fapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class QuestionDto {

    private Long id;
    private String text;
    private AnswerTypeDto answerType;
    private Set<AnswerOptionDto> rightAnswer;
    private Set<AnswerOptionDto> possibleAnswer;
}
