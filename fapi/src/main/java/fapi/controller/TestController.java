package fapi.controller;

import fapi.dto.UserDto;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/fapi")
@Controller
public class TestController {

    @Autowired
    UserService userService;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my-profile")
    public ResponseEntity<UserDto> getProfile() {
        List<UserDto> userDtos = (List<UserDto>) userService.findALL();
        for (UserDto userDto : userDtos) {
            if (userDto.getUsername().equals(getCurrentUsername()))
                return ResponseEntity.ok(userDto);
        }
        return null;
    }
}
