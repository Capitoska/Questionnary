package fapi.dto.converter;

import fapi.dto.RoleDto;
import fapi.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements DefaultConverter<RoleDto, RoleEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public RoleDto toDto(RoleEntity roleEntity) {
        return roleEntity == null ? null : mapper.map(roleEntity, RoleDto.class);
    }

    @Override
    public RoleEntity toEntity(RoleDto roleDto) {
        return roleDto == null? null: mapper.map(roleDto,RoleEntity.class);
    }
}
