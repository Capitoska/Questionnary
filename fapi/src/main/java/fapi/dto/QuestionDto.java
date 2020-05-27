package fapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto {

    private Long id;
    private String text;
    private AnswerTypeDto answerType;
    @JsonProperty("answers")
    private Set<AnswerOptionDto> possibleAnswer;
}
