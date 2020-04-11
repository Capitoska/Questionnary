package fapi.controller;

import fapi.dto.UserDto;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("${fapi.fina.url}" + "${backend.user.url}")
@RequestMapping("/api/fapi/users/")
public class UserController  {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto = userService.findById(id).get();
        return ResponseEntity.ok(userDto);
    }

    @RequestMapping
    public ResponseEntity<Iterable<UserDto>> getAllUsers(){
        List<UserDto> userDtoList = (List<UserDto>) userService.findALL();
        return ResponseEntity.ok(userDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        dto = userService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
