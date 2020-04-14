package nk.trainings.backend.controller;

import nk.trainings.backend.entity.UserAnswerEntity;
import nk.trainings.backend.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user-answers")
public class UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserAnswerEntity> getUserAnswerById(@PathVariable(name = "id") Long id) {
        Optional<UserAnswerEntity> userAnswerEntity = userAnswerService.findById(id);
        return userAnswerEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserAnswerEntity> getAllUserAnswer() {
        return userAnswerService.findALL();
    }

//    todo неккоректная работа сохранения Entity. Продумать.
    @RequestMapping(value = "", method =RequestMethod.POST)
    public UserAnswerEntity save(UserAnswerEntity userEntity) {
        return userAnswerService.save(userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(name = "id") Long id) {
        userAnswerService.deleteById(id);
    }

}
