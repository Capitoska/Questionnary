package nk.trainings.backend.controller;

import nk.trainings.backend.entity.AnswerOptionEntity;
import nk.trainings.backend.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/answer-options")
public class AnswerOptionController {

    @Autowired
    AnswerOptionService answerOptionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerOptionEntity> getAnswerOptionById(@PathVariable(name = "id") Long id) {
        Optional<AnswerOptionEntity> answerOptionEntity = answerOptionService.findById(id);
        return answerOptionEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<AnswerOptionEntity> getAllAnswerOptionAnswer() {
        return answerOptionService.findALL();
    }

    @PostMapping
    public AnswerOptionEntity save(@RequestBody AnswerOptionEntity answerOptionEntity) {
        return answerOptionService.save(answerOptionEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        answerOptionService.deleteById(id);
    }
}
