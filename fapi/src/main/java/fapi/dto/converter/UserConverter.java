package fapi.dto.converter;

import fapi.dto.UserDto;
import fapi.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements DefaultConverter<UserDto, UserEntity> {

    @Autowired
    ModelMapper mapper;
//    final
//    ModelMapper mapper;
//
//    @Autowired
//    public UserConverter(ModelMapper mapper) {
//        this.mapper = mapper;
//    }

    @Override
    public UserDto toDto(UserEntity userEntity) {
        return userEntity == null ? null : mapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity toEntity(UserDto userDTO) {
        return userDTO == null ? null : mapper.map(userDTO, UserEntity.class);
    }
}
