package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.RoleEntity;
import nk.trainings.backend.repository.RoleRepository;
import nk.trainings.backend.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public RoleEntity getById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public RoleEntity getByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional
    public Iterable<RoleEntity> getAll() {
        return roleRepository.findAll();
    }
}
