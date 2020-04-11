package fapi.dto.converter;

import fapi.dto.AnswerOptionDto;
import fapi.entity.AnswerOptionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerOptionConverter implements DefaultConverter<AnswerOptionDto, AnswerOptionEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public AnswerOptionDto toDto(AnswerOptionEntity answerOptionEntity) {
        return answerOptionEntity == null? null: mapper.map(answerOptionEntity, AnswerOptionDto.class);
    }

    @Override
    public AnswerOptionEntity toEntity(AnswerOptionDto answerOptionDTO) {
        return answerOptionDTO == null? null: mapper.map(answerOptionDTO, AnswerOptionEntity.class);
    }
}
