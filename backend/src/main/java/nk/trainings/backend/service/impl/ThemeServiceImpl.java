package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.ThemeEntity;
import nk.trainings.backend.repository.ThemeRepository;
import nk.trainings.backend.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    ThemeRepository themeRepository;

    @Override
    public Iterable<ThemeEntity> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Optional<ThemeEntity> findById(Long id) {
        return themeRepository.findById(id);
    }

    @Override
    public ThemeEntity save(@RequestBody ThemeEntity themeEntity) {
        return themeRepository.save(themeEntity);
    }

    @Override
    public void deleteById(Long id) {
        themeRepository.deleteById(id);
    }
}
