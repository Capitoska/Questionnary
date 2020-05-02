package fapi.controller;

import fapi.dto.UserDto;
import fapi.service.UserService;
import fapi.utils.AuthorizationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/fapi")
@Controller
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    AuthorizationBean authorizationBean;

    @RequestMapping(method = RequestMethod.GET, value = "/my-profile")
    public ResponseEntity<UserDto> getProfile() {
        return ResponseEntity.ok(authorizationBean.getAuthorizedUserDTO());
    }
}
