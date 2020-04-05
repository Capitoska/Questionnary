package nk.trainings.backend.controller;

import nk.trainings.backend.entity.ThemeEntity;
import nk.trainings.backend.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ThemeEntity> getUserAnswerById(@PathVariable(name = "id") Long id) {
        Optional<ThemeEntity> themeEntity = themeService.findById(id);
        return themeEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<ThemeEntity> getAllUserAnswer() {
        return themeService.findALL();
    }

    @PostMapping
    public ThemeEntity save(@RequestBody ThemeEntity userEntity) {
        return themeService.save(userEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        themeService.deleteById(id);
    }

}
