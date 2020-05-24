package fapi.utils;

import fapi.dto.UserDto;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;


public class AuthorizationBean {

    @Autowired
    UserService userService;

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public UserDto getAuthorizedUserDTO() {
        List<UserDto> userDtos = (List<UserDto>) userService.findALL();
        for (UserDto userDto : userDtos) {
            if (userDto.getUsername().equals(getCurrentUsername()))
                return userDto;
        }
        return null;
    }
}
