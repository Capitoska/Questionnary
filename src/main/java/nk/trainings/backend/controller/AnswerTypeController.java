package nk.trainings.backend.controller;

import nk.trainings.backend.entity.AnswerTypeEntity;
import nk.trainings.backend.service.AnswerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/answer-types")
public class AnswerTypeController {

    @Autowired
    AnswerTypeService answerTypeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerTypeEntity> getAnswerTypeById(@PathVariable(name = "id") Long id) {
        Optional<AnswerTypeEntity> answerTypeEntity = answerTypeService.findById(id);
        return answerTypeEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<AnswerTypeEntity> getAllAnswerTypeAnswer() {
        return answerTypeService.findALL();
    }

    @PostMapping
    public AnswerTypeEntity save(@RequestBody AnswerTypeEntity answerTypeEntity) {
        return answerTypeService.save(answerTypeEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        answerTypeService.deleteById(id);
    }

}
