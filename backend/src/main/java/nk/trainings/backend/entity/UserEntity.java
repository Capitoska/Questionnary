package nk.trainings.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "mail")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "third_name")
    private String third_name;

    @Column(name = "birthday")
    private String birthday;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;
}
