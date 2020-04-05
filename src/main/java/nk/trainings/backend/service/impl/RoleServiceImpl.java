package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.repository.RoleRepository;
import nk.trainings.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<RoleEntity> findALL() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public RoleEntity save(@RequestBody RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
