package fapi.service.impl;

import fapi.dto.QuizDto;
import fapi.dto.converter.QuizConverter;
import fapi.entity.QuizEntity;
import fapi.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Value("${backend.server.url}" + "${backend.quiz.url}")
    private String backendQuizUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    QuizConverter quizConverter;



    @Override
    public Iterable<QuizDto> findALL() {
        QuizEntity[] themeEntities = restTemplate.getForObject(backendQuizUrl,QuizEntity[].class);
        return themeEntities.length== 0? null:
                quizConverter.ToDtoList(Arrays.stream(themeEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<QuizDto> findById(Long id) {
        QuizEntity quizEntity = restTemplate.getForObject(backendQuizUrl + id,QuizEntity.class);
        return Optional.ofNullable(quizConverter.toDto(quizEntity));
    }

    @Override
    public QuizDto save(QuizDto dto) {
        restTemplate.postForObject(backendQuizUrl,quizConverter.toEntity(dto),QuizEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendQuizUrl + id);
    }
}
