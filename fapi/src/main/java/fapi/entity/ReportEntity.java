package fapi.entity;

import lombok.Data;

@Data
public class ReportEntity {

    private Long id;
    private String text;
    private UserEntity reporter;
    private QuizEntity quiz;
}
