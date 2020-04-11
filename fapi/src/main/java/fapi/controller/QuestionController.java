package fapi.controller;

import fapi.dto.QuestionDto;
import fapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fapi/questiones")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionDto> getUserAnswerById(@PathVariable Long id) {
        QuestionDto questionDto = questionService.findById(id).get();
        return ResponseEntity.ok(questionDto);
    }

    @RequestMapping
    public ResponseEntity<Iterable<QuestionDto>> getAllUserAnswers() {
        List<QuestionDto> QuestionDtoList = (List<QuestionDto>) questionService.findALL();
        return ResponseEntity.ok(QuestionDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<QuestionDto> save(@RequestBody QuestionDto dto) {
        dto = questionService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }
}
