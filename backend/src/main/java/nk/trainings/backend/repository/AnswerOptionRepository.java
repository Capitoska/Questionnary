package nk.trainings.backend.repository;

import nk.trainings.backend.entity.AnswerOptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionRepository extends CrudRepository<AnswerOptionEntity, Long> {
}
