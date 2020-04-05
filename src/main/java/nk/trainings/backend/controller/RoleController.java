package nk.trainings.backend.controller;

import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleEntity> getRoleById(@PathVariable(name = "id") Long id) {
        Optional<RoleEntity> roleEntity = roleService.findById(id);
        return roleEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "")
    public Iterable<RoleEntity> getAllRoleAnswer() {
        return roleService.findALL();
    }

    @PostMapping
    public RoleEntity save(@RequestBody RoleEntity roleEntity) {
        return roleService.save(roleEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(name = "id") Long id) {
        roleService.deleteById(id);
    }



}
