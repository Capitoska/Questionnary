package fapi.dto.converter;

import fapi.dto.AnswerTypeDto;
import fapi.entity.AnswerTypeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerTypeConverter  implements DefaultConverter<AnswerTypeDto, AnswerTypeEntity> {
    @Autowired
    ModelMapper mapper;

    @Override
    public AnswerTypeDto toDto(AnswerTypeEntity answerTypeEntity) {
        return answerTypeEntity == null?null: mapper.map(answerTypeEntity, AnswerTypeDto.class);
    }

    @Override
    public AnswerTypeEntity toEntity(AnswerTypeDto answerTypeDTO) {
        return answerTypeDTO == null? null:mapper.map(answerTypeDTO,AnswerTypeEntity.class);
    }
}
