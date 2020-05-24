package fapi.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface DefaultConverter<DTO, ENTITY> {
    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);

    default List<DTO> ToDtoList(List<ENTITY> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

//    default List<DTO> ToDTOList(ENTITY [] entities){
//      return Arrays.stream(entities).map(this::toDto).collect(Collectors.toList());
//    }
}
