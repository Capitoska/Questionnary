package fapi.service.impl;

import fapi.dto.ThemeDto;
import fapi.dto.converter.ThemeConverter;
import fapi.entity.ThemeEntity;
import fapi.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Value("${backend.server.url}" + "${backend.theme.url}")
    private String backendThemeUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ThemeConverter themeConverter;

    @Override
    public Iterable<ThemeDto> findALL() {
        ThemeEntity[] themeEntities = restTemplate.getForObject(backendThemeUrl, ThemeEntity[].class);
        return themeEntities.length == 0 ? null :
                themeConverter.toDtoList(Arrays.stream(themeEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<ThemeDto> findById(Long id) {
        ThemeEntity themeEntity = restTemplate.getForObject(backendThemeUrl + id, ThemeEntity.class);
        return Optional.ofNullable(themeConverter.toDto(themeEntity));
    }

    @Override
    public ThemeDto save(ThemeDto dto) {
        restTemplate.postForObject(backendThemeUrl, themeConverter.toEntity(dto), ThemeEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendThemeUrl + id);
    }
}
