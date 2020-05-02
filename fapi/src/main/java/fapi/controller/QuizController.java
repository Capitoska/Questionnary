package fapi.controller;

import fapi.dto.QuizDto;
import fapi.service.QuizService;
import fapi.utils.AuthorizationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fapi/quizes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private AuthorizationBean authorizationBean;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuizDto> getUserAnswerById(@PathVariable Long id) {
        QuizDto quizDto = quizService.findById(id).get();
        return ResponseEntity.ok(quizDto);
    }

    @RequestMapping
    public ResponseEntity<Iterable<QuizDto>> getAllUserAnswers() {
        List<QuizDto> QuizDtoList = (List<QuizDto>) quizService.findALL();
        return ResponseEntity.ok(QuizDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<QuizDto> save(@RequestBody QuizDto dto) {
        dto.setAuthor(authorizationBean.getAuthorizedUserDTO());
        dto = quizService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        quizService.deleteById(id);
    }
}
