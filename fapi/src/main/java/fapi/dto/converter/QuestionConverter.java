package fapi.dto.converter;

import fapi.dto.QuestionDto;
import fapi.entity.QuestionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter implements DefaultConverter<QuestionDto, QuestionEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public QuestionDto toDto(QuestionEntity questionEntity) {
        return questionEntity == null ? null : mapper.map(questionEntity, QuestionDto.class);
    }

    @Override
    public QuestionEntity toEntity(QuestionDto questionDTO) {
        return questionDTO == null ? null : mapper.map(questionDTO, QuestionEntity.class);
    }
}
