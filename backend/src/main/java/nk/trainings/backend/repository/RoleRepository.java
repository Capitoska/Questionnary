package nk.trainings.backend.repository;

import nk.trainings.backend.entity.RoleEntity;

public interface RoleRepository {
    RoleEntity findById(Long id);
    RoleEntity findByName(String name);
    Iterable<RoleEntity> findAll();
}
