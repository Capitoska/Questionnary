package fapi.service.impl;

import fapi.dto.AnswerOptionDto;
import fapi.dto.converter.AnswerOptionConverter;
import fapi.entity.AnswerOptionEntity;
import fapi.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerOptionServiceImpl implements AnswerOptionService {

    @Value("${backend.server.url}" + "${backend.answer-option.url}")
    private String backendAnswerOptionUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AnswerOptionConverter answerOptionConverter;

    @Override
    public Iterable<AnswerOptionDto> findALL() {
        AnswerOptionEntity[] AnswerOptionEntities = restTemplate.getForObject(backendAnswerOptionUrl, AnswerOptionEntity[].class);
        return AnswerOptionEntities.length == 0 ? null :
                answerOptionConverter.ToDtoList(Arrays.stream(AnswerOptionEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<AnswerOptionDto> findById(Long id) {
        AnswerOptionEntity AnswerOptionEntity = restTemplate.getForObject(backendAnswerOptionUrl + id, AnswerOptionEntity.class);
        return Optional.ofNullable(answerOptionConverter.toDto(AnswerOptionEntity));
    }


    @Override
    public AnswerOptionDto save(AnswerOptionDto dto) {
        AnswerOptionEntity answerOptionEntity = restTemplate.postForObject(backendAnswerOptionUrl, answerOptionConverter.toEntity(dto), AnswerOptionEntity.class);
        return answerOptionConverter.toDto(answerOptionEntity);
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendAnswerOptionUrl + id);
    }

    @Override
    public Optional<AnswerOptionDto> getByValue(String value) {
        AnswerOptionEntity answerOptionEntity = restTemplate.getForObject(backendAnswerOptionUrl + "value/" + value, AnswerOptionEntity.class);
        return Optional.ofNullable(answerOptionConverter.toDto(answerOptionEntity));
    }
}
