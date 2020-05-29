package fapi.service.impl;

import fapi.dto.QuizDto;
import fapi.dto.converter.QuizConverter;
import fapi.entity.QuizEntity;
import fapi.service.QuestionService;
import fapi.service.QuizService;
import fapi.utils.Base64Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Value("${backend.server.url}" + "${backend.quiz.url}")
    private String backendQuizUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    QuestionService questionService;

    @Autowired
    QuizConverter quizConverter;

    @Autowired
    Base64Bean base64Bean;

    @Override
    public Iterable<QuizDto> findALL() {
        QuizEntity[] quizEntities = restTemplate.getForObject(backendQuizUrl, QuizEntity[].class);
        return quizEntities.length == 0 ? null :
                quizConverter.toDtoList(Arrays.stream(quizEntities).collect(Collectors.toList()));
    }


    @Override
    public Optional<QuizDto> findByIdOrUrl(String finder){
        try {
            return findById(Long.parseLong(finder));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Optional<QuizDto> findById(Long id) {
        QuizEntity quizEntity = restTemplate.getForObject(backendQuizUrl + id, QuizEntity.class);
        return Optional.ofNullable(quizConverter.toDto(quizEntity));
    }

    @Override
    public QuizDto save(QuizDto dto) {
//        dto.setQuestions(questionService.saveAll(dto.getQuestions()));
        restTemplate.postForObject(backendQuizUrl, quizConverter.toEntity(dto), QuizEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendQuizUrl + id);
    }

    //todo прописать запрос правильно.
    @Override
    public Iterable<QuizDto> findByName(String name) {
        QuizEntity[] quizEntities = restTemplate.getForObject(backendQuizUrl + "name/" + name, QuizEntity[].class);
        return quizConverter.toDtoList(Arrays.stream(quizEntities).collect(Collectors.toList()));
    }


    @Override
    public boolean generateUrlAddress(QuizDto quizDto) {
        QuizEntity quizEntity = quizConverter.toEntity(quizDto);
        Random random = new Random();
        String newUrlAddress = null;
        try {
            newUrlAddress = base64Bean.encodeString(quizEntity.getId() +
                    quizEntity.getName() + random.nextInt(1_000_000));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        quizEntity.setUrlAddress(newUrlAddress);
        restTemplate.put(backendQuizUrl, quizEntity, QuizEntity.class);
        return true;
    }

    @Override
    public void update(QuizDto quizDto) {
        QuizEntity quizEntity = quizConverter.toEntity(quizDto);
        restTemplate.put(backendQuizUrl, null, quizEntity);
    }
}
