package nk.trainings.backend.repository;

import nk.trainings.backend.entity.UserAnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswerEntity, Long> {

}
