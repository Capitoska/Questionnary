package nk.trainings.backend.repository;

import nk.trainings.backend.entity.QuizEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<QuizEntity, Long> {
}
