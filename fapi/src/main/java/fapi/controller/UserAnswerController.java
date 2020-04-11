package fapi.controller;

import fapi.dto.UserAnswerDto;
import fapi.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fapi/user-answers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserAnswerDto> getUserAnswerById(@PathVariable Long id) {
        UserAnswerDto userAnswerDto = userAnswerService.findById(id).get();
        return ResponseEntity.ok(userAnswerDto);
    }

    @RequestMapping
    public ResponseEntity<Iterable<UserAnswerDto>> getAllUserAnswers() {
        List<UserAnswerDto> UserAnswerDtoList = (List<UserAnswerDto>) userAnswerService.findALL();
        return ResponseEntity.ok(UserAnswerDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserAnswerDto> save(@RequestBody UserAnswerDto dto) {
        dto = userAnswerService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userAnswerService.deleteById(id);
    }
}
