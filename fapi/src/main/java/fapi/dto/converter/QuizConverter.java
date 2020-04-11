package fapi.dto.converter;

import fapi.dto.QuizDto;
import fapi.entity.QuizEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizConverter implements DefaultConverter<QuizDto, QuizEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public QuizDto toDto(QuizEntity quizEntity) {
        return quizEntity == null? null: mapper.map(quizEntity, QuizDto.class);
    }

    @Override
    public QuizEntity toEntity(QuizDto quizDTO) {
        return quizDTO == null? null:mapper.map(quizDTO, QuizEntity.class);
    }
}
