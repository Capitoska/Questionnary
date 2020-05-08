package nk.trainings.backend.controller;

import lombok.extern.log4j.Log4j2;
import nk.trainings.backend.entity.QuizEntity;
import nk.trainings.backend.entity.UserEntity;
import nk.trainings.backend.service.QuizService;
import nk.trainings.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Long id) {
        Optional<UserEntity> userEntity = userService.findById(id);
        return userEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable(name = "username") String username) {
        Optional<UserEntity> userEntity = Optional.ofNullable(userService.findByUsername(username));
        return userEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Iterable<UserEntity> getUsers(@RequestParam(value = "testik", required = false) String testik){
        System.out.println(testik);
        return null;
    }

    @RequestMapping(value = "{id}/quizes/", method = RequestMethod.GET)
    public Iterable<QuizEntity> getQuizByUser(@PathVariable(name = "id") Long id){
        return quizService.findAllByAuthor_Id(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        log.info("HEEEY");
        return userService.save(userEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
    }
}
