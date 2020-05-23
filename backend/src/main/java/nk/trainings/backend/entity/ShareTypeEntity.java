package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "share_type")
public class ShareTypeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String typeName;
}
