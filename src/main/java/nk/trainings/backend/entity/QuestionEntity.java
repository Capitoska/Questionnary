package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String text;

    //  COMPLETE  todo ManyToOne связь
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AnswerTypeEntity answerType;

    //  COMPLETE  todo ManyToMany связь.
    @ManyToMany
    @JoinTable(
            name = "right_answers",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<AnswerOptionEntity> rightAnswer;

    //  COMPLETE  todo ManyToMany связь
    @ManyToMany
    @JoinTable(
            name = "questions_answer_options",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<AnswerOptionEntity> possibleAnswer;
}
