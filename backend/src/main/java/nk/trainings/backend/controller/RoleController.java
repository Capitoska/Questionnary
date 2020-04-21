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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RoleEntity getRoleById(@PathVariable(name = "id") Long id) {
        RoleEntity roleEntity = roleService.getById(id);
        return roleEntity;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<RoleEntity> getAllRoleAnswer() {
        return roleService.getAll();
    }



}
