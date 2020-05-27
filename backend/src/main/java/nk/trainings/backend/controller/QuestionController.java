package nk.trainings.backend.controller;

import nk.trainings.backend.entity.AnswerTypeEntity;
import nk.trainings.backend.entity.QuestionEntity;
import nk.trainings.backend.service.QuestionService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @PersistenceContext
    EntityManager entityManager;

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
        Session session = entityManager.unwrap(Session.class);
        questionEntity.setAnswerType(session.get(AnswerTypeEntity.class,questionEntity.getAnswerType().getId()));
        return questionService.save(questionEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }

}
