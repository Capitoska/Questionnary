package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "themes")
public class ThemeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
