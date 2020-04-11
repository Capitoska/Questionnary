package fapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class QuizDto {

    private Long id;
    private String name;
    private UserDto author;
    private Set<QuestionDto> questions;
    private Boolean isOpen;
}
