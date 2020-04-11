package fapi.controller;

import fapi.dto.AnswerTypeDto;
import fapi.service.AnswerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fapi/answer-types")
public class AnswerTypeController {

    @Autowired
    private AnswerTypeService answerTypeService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AnswerTypeDto> getUserAnswerById(@PathVariable Long id) {
        AnswerTypeDto AnswerTypeController = answerTypeService.findById(id).get();
        return ResponseEntity.ok(AnswerTypeController);
    }

    @RequestMapping
    public ResponseEntity<Iterable<AnswerTypeDto>> getAllUserAnswers() {
        List<AnswerTypeDto> AnswerTypeDtoList = (List<AnswerTypeDto>) answerTypeService.findALL();
        return ResponseEntity.ok(AnswerTypeDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AnswerTypeDto> save(@RequestBody AnswerTypeDto dto) {
        dto = answerTypeService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        answerTypeService.deleteById(id);
    }
}
