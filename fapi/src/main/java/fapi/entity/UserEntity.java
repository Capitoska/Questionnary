package fapi.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String first_name;
    private String second_name;
    private String email;
    private String password;
    private String third_name;
    private String birthday;
    private RoleEntity role;
}
