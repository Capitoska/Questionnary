package nk.trainings.backend.controller;

import nk.trainings.backend.entity.QuestionEntity;
import nk.trainings.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionEntity> getQuestionById(@PathVariable(name = "id") Long id) {
        Optional<QuestionEntity> questionEntity = questionService.findById(id);
        return questionEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<QuestionEntity> getAllQuestionAnswer() {
        return questionService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public QuestionEntity save(@RequestBody QuestionEntity questionEntity) {
        return questionService.save(questionEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }

}
