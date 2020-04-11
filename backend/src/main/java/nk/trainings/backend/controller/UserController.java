package nk.trainings.backend.controller;

import nk.trainings.backend.entity.UserEntity;
import nk.trainings.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Long id) {
        Optional<UserEntity> userEntity = userService.findById(id);
        return userEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping(value = "")
    public Iterable<UserEntity> getAllUsers() {

        return userService.findALL();
    }

    @PostMapping()
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
    }
}
