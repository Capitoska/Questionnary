package fapi.controller;

import fapi.dto.ThemeDto;
import fapi.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fapi/themes")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

// small test for Pull Request. Hehehehe
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ThemeDto> getThemeById(@PathVariable Long id) {
        ThemeDto themeDto = themeService.findById(id).get();
        return ResponseEntity.ok(themeDto);
    }

    @RequestMapping
    public ResponseEntity<Iterable<ThemeDto>> getAllThemes() {
        List<ThemeDto> themeDtoList = (List<ThemeDto>) themeService.findALL();
        return ResponseEntity.ok(themeDtoList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ThemeDto> save(@RequestBody ThemeDto dto) {
        dto = themeService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        themeService.deleteById(id);
    }
}
