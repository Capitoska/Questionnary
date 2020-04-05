package nk.trainings.backend.service;

import nk.trainings.backend.entity.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Iterable<RoleEntity> findALL();

    Optional<RoleEntity> findById(Long id);

    RoleEntity save(RoleEntity roleEntity);

    void deleteById(Long id);
}
