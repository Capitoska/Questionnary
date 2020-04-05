package nk.trainings.backend.service;

import nk.trainings.backend.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    Iterable<UserEntity> findALL();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);

    void deleteById(Long id);
}
