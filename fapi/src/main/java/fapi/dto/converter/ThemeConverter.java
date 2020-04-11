package fapi.dto.converter;

import fapi.dto.ThemeDto;
import fapi.entity.ThemeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThemeConverter implements DefaultConverter<ThemeDto, ThemeEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public ThemeDto toDto(ThemeEntity themeEntity) {
        return themeEntity == null? null: mapper.map(themeEntity, ThemeDto.class);
    }

    @Override
    public ThemeEntity toEntity(ThemeDto themeDTO) {
        return themeDTO == null? null:mapper.map(themeDTO, ThemeEntity.class);
    }
}
