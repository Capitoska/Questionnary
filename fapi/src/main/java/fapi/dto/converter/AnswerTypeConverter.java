package fapi.dto.converter;

import fapi.dto.AnswerTypeDto;
import fapi.entity.AnswerTypeEntity;
import fapi.service.AnswerTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerTypeConverter implements DefaultConverter<AnswerTypeDto, AnswerTypeEntity> {

    @Autowired
    ModelMapper mapper;

    @Autowired
    AnswerTypeService answerTypeService;

    @Override
    public AnswerTypeDto toDto(AnswerTypeEntity answerTypeEntity) {
        return answerTypeEntity == null ? null : mapper.map(answerTypeEntity, AnswerTypeDto.class);
    }

    //todo костыли. Сильные костыли!!!
    public AnswerTypeEntity toEntity(String value){
        AnswerTypeDto answerTypeDto = answerTypeService.getAnswerTypeByValue(value).get();
        return toEntity(answerTypeDto);
    }

    @Override
    public AnswerTypeEntity toEntity(AnswerTypeDto answerTypeDTO) {
        if (answerTypeDTO.getId() == null){
           return toEntity(answerTypeDTO.getValue());
        }
        return answerTypeDTO == null ? null : mapper.map(answerTypeDTO, AnswerTypeEntity.class);
    }
}
