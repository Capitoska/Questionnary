package nk.trainings.backend.controller;

import nk.trainings.backend.entity.UserAnswerEntity;
import nk.trainings.backend.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-answers")
public class    UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserAnswerEntity> getUserAnswerById(@PathVariable(name = "id") Long id) {
        Optional<UserAnswerEntity> userAnswerEntity = userAnswerService.findById(id);
        return userAnswerEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserAnswerEntity> getAllUserAnswer() {
        return userAnswerService.findAll();
    }

//    todo неккоректная работа сохранения Entity. Продумать.
    @RequestMapping(value = "", method =RequestMethod.POST)
    public List<UserAnswerEntity> save(@RequestBody List<UserAnswerEntity> userAnswerEntities) {
        return userAnswerService.saveAll(userAnswerEntities);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(name = "id") Long id) {
        userAnswerService.deleteById(id);
    }

}
