package nk.trainings.backend.service;

import nk.trainings.backend.entity.ThemeEntity;

import java.util.Optional;

public interface ThemeService {
    Iterable<ThemeEntity> findALL();

    Optional<ThemeEntity> findById(Long id);

    ThemeEntity save(ThemeEntity themeEntity);

    void deleteById(Long id);
}
