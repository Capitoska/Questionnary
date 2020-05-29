package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity reporter;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quiz;
}
