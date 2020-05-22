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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerOptionEntity> getAnswerOptionById(@PathVariable(name = "id") Long id) {
        Optional<AnswerOptionEntity> answerOptionEntity = answerOptionService.findById(id);
        return answerOptionEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/value/{value}", method = RequestMethod.GET)
    public Optional<AnswerOptionEntity> getByValue(@PathVariable(name = "value") String value){
        return answerOptionService.findByValue(value);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Iterable<AnswerOptionEntity> getAllAnswerOptionAnswer() {
        return answerOptionService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public AnswerOptionEntity save(@RequestBody AnswerOptionEntity answerOptionEntity) {
        return answerOptionService.save(answerOptionEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        answerOptionService.deleteById(id);
    }
}
