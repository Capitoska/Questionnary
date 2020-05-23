package fapi.service.impl;

import fapi.dto.AnswerTypeDto;
import fapi.dto.converter.AnswerTypeConverter;
import fapi.entity.AnswerTypeEntity;
import fapi.service.AnswerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerTypeServiceImpl implements AnswerTypeService {

    @Value("${backend.server.url}" + "${backend.answer-type.url}")
    private String backendAnswerTypeUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AnswerTypeConverter AnswerTypeConverter;


    @Override
    public Iterable<AnswerTypeDto> findALL() {
        AnswerTypeEntity[] answerTypeEntity = restTemplate.getForObject(backendAnswerTypeUrl, AnswerTypeEntity[].class);
        return answerTypeEntity.length == 0 ? null :
                AnswerTypeConverter.ToDtoList(Arrays.stream(answerTypeEntity).collect(Collectors.toList()));
    }

    @Override
    public Optional<AnswerTypeDto> findById(Long id) {
        AnswerTypeEntity answerTypeEntity = restTemplate.getForObject(backendAnswerTypeUrl + id, AnswerTypeEntity.class);
        return Optional.ofNullable(AnswerTypeConverter.toDto(answerTypeEntity));
    }

    @Override
    public AnswerTypeDto save(AnswerTypeDto dto) {
        restTemplate.postForObject(backendAnswerTypeUrl, AnswerTypeConverter.toEntity(dto), AnswerTypeEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendAnswerTypeUrl + id);
    }
}
