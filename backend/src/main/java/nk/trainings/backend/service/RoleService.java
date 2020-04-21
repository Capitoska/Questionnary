package nk.trainings.backend.service;

import nk.trainings.backend.entity.RoleEntity;

public interface RoleService{
    RoleEntity getById(Long id);
    RoleEntity getByName(String name);
    Iterable<RoleEntity> getAll();
}
