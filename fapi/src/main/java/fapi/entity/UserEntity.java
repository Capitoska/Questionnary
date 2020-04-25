package fapi.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserEntity {
    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String thirdName;
    private LocalDate birthday;
    private RoleEntity role;
}
