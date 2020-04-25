package nk.trainings.backend.controller;

import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RoleEntity getRoleById(@PathVariable(name = "id") Long id) {
        return roleService.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<RoleEntity> getAllRoleAnswer() {
        return roleService.getAll();
    }



}
