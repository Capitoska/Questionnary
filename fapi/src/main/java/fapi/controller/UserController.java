package fapi.controller;

import fapi.dto.UserDto;
import fapi.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
//@RequestMapping("${fapi.fina.url}" + "${backend.user.url}")
@RequestMapping("/api/fapi/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id).get();
        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = (List<UserDto>) userService.findALL();
        return ResponseEntity.ok(userDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        dto = userService.save(dto);
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
        return ResponseEntity.ok(dto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
