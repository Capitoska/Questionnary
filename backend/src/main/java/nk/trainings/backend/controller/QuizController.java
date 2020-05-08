package nk.trainings.backend.controller;

import nk.trainings.backend.entity.QuizEntity;
import nk.trainings.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/quizes")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuizEntity> getQuizById(@PathVariable(name = "id") Long id) {
        Optional<QuizEntity> quizEntity = quizService.findById(id);
        return quizEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public QuizEntity getQuiz(@RequestParam(name = "id", required = false) Long id, @RequestParam(name="name", required = false)String name) {
//        Optional<QuizEntity> quizEntity;
//        if(id != null) {
//            quizEntity = quizService.findById(id);
//        }
//
//        if(name != null){
//            quizEntity = quizService.findByName(name);
//        }
//
//        return quizEntity.orElse(null);
//    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Iterable<QuizEntity> getAllByName(@PathVariable String name) {
        return quizService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public QuizEntity update(@RequestBody QuizEntity quizEntity) {
        return quizService.update(quizEntity);
    }

    @RequestMapping(value = "/{id}/generate-url", method = RequestMethod.PUT)
    public HttpStatus generateUrl(@PathVariable Long id) {
        QuizEntity quizEntity = quizService.findById(id).get();
        quizService.update(quizEntity);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<QuizEntity> getAllQuizAnswer() {
        return quizService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public QuizEntity save(@RequestBody QuizEntity quizEntity) {
        return quizService.save(quizEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        quizService.deleteById(id);
    }

}
