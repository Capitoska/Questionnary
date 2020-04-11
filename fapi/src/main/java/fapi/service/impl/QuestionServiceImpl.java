package fapi.service.impl;

import fapi.dto.QuestionDto;
import fapi.dto.converter.QuestionConverter;
import fapi.entity.QuestionEntity;
import fapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Value("${backend.server.url}" + "${backend.question.url}")
    private String backendQuestionUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    QuestionConverter questionConverter;



    @Override
    public Iterable<QuestionDto> findALL() {
        QuestionEntity[] themeEntities = restTemplate.getForObject(backendQuestionUrl,QuestionEntity[].class);
        return themeEntities.length== 0? null:
                questionConverter.ToDtoList(Arrays.stream(themeEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<QuestionDto> findById(Long id) {
        QuestionEntity questionEntity = restTemplate.getForObject(backendQuestionUrl + id,QuestionEntity.class);
        return Optional.ofNullable(questionConverter.toDto(questionEntity));
    }

    @Override
    public QuestionDto save(QuestionDto dto) {
        restTemplate.postForObject(backendQuestionUrl,questionConverter.toEntity(dto),QuestionEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendQuestionUrl + id);
    }
}
