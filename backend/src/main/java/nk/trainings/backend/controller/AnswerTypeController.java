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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerTypeEntity> getAnswerTypeById(@PathVariable(name = "id") Long id) {
        Optional<AnswerTypeEntity> answerTypeEntity = answerTypeService.findById(id);
        return answerTypeEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/value/{value}")
    public  ResponseEntity<AnswerTypeEntity> getAnswerTypeByValue(@PathVariable(name = "value") String value){
        Optional<AnswerTypeEntity> answerTypeEntity = answerTypeService.findByValue(value);
        return answerTypeEntity.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AnswerTypeEntity> getAllAnswerTypeAnswer() {
        return answerTypeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public AnswerTypeEntity save(@RequestBody AnswerTypeEntity answerTypeEntity) {
        return answerTypeService.save(answerTypeEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        answerTypeService.deleteById(id);
    }

}
