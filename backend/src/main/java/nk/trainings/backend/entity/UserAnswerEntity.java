package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_answer")
public class UserAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private AnswerOptionEntity answer;

}
