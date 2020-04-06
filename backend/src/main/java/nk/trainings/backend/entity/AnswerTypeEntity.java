package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "answer_types")
public class AnswerTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String value;
}
