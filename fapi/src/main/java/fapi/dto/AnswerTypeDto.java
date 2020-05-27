package fapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerTypeDto {

    private Long id;
    private String value;

    public AnswerTypeDto(String value) {
        this.value = value;
    }
}
