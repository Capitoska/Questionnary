package fapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String thirdName;
    private RoleDto role;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
}
