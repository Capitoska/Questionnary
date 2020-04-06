package nk.trainings.backend.controller;

import nk.trainings.backend.entity.UserAnswerEntity;
import nk.trainings.backend.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user-answers")
public class UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAnswerEntity> getUserAnswerById(@PathVariable(name = "id") Long id) {
        Optional<UserAnswerEntity> userAnswerEntity = userAnswerService.findById(id);
        return userAnswerEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<UserAnswerEntity> getAllUserAnswer() {
        return userAnswerService.findALL();
    }

//    todo неккоректная работа сохранения Entity. Продумать.
    @PostMapping
    public UserAnswerEntity save(UserAnswerEntity userEntity) {
        return userAnswerService.save(userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(name = "id") Long id) {
        userAnswerService.deleteById(id);
    }

}
