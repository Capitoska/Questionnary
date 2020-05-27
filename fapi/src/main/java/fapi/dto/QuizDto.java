package fapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizDto {
    private Long id;
    private String name;
    private UserDto author;
    private Set<QuestionDto> questions;
    private Boolean isOpen;
    private String urlAddress;
}