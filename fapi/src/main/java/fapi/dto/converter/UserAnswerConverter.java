package fapi.dto.converter;

import fapi.dto.UserAnswerDto;
import fapi.entity.UserAnswerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAnswerConverter implements DefaultConverter<UserAnswerDto, UserAnswerEntity> {

    @Autowired
    final ModelMapper mapper;

    @Autowired
    public UserAnswerConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserAnswerDto toDto(UserAnswerEntity userAnswerEntity) {
        return userAnswerEntity == null ? null : mapper.map(userAnswerEntity, UserAnswerDto.class);
    }

    @Override
    public UserAnswerEntity toEntity(UserAnswerDto userAnswerDTO) {
        return userAnswerDTO == null ? null : mapper.map(userAnswerDTO, UserAnswerEntity.class);
    }
}
