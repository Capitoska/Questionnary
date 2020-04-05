package nk.trainings.backend.controller;

import nk.trainings.backend.entity.QuizEntity;
import nk.trainings.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/quizes")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuizEntity> getQuizById(@PathVariable(name = "id") Long id) {
        Optional<QuizEntity> quizEntity = quizService.findById(id);
        return quizEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<QuizEntity> getAllQuizAnswer() {
        return quizService.findALL();
    }

    @PostMapping
    public QuizEntity save(@RequestBody QuizEntity quizEntity) {
        return quizService.save(quizEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        quizService.deleteById(id);
    }

}
