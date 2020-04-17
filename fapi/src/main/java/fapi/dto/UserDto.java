package fapi.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String first_name;
    private String second_name;
    private String email;
    private String password;
    private String third_name;
    private String birthday;
    private RoleDto role;
}
