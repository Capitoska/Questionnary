package fapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    private String name;
    private UserDto author;
    private Set<QuestionDto> questions;
    private Boolean isOpen;
    private String urlAddress;
}