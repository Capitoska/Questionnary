package nk.trainings.backend.service;

import nk.trainings.backend.entity.UserAnswerEntity;

import java.util.Optional;

public interface UserAnswerService {
    Iterable<UserAnswerEntity> findALL();

    Optional<UserAnswerEntity> findById(Long id);

    UserAnswerEntity save(UserAnswerEntity userAnswerEntity);

    void deleteById(Long id);
}
