package nk.trainings.backend.repository;

import nk.trainings.backend.entity.AnswerTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerTypeRepository extends CrudRepository<AnswerTypeEntity, Long> {
}
