package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    private Set<QuestionEntity> questions;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "share_type_id")
    private ShareTypeEntity shareTypeEntity;

    @Column(name = "url")
    private String urlAddress;
}
