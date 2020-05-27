package fapi.service;


import fapi.dto.QuizDto;
import fapi.dto.UserDto;

import java.util.List;

public interface UserService extends DefaultService<UserDto> {
    List<QuizDto> findAllQuizesByAuthenticateUser();
     UserDto findByUsername(String username);
}
