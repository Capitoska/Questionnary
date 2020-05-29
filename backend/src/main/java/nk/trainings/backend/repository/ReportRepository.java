package nk.trainings.backend.repository;

import nk.trainings.backend.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<ReportEntity,Long> {
    Iterable<ReportEntity> getAllByQuiz_Id(Long quizId);
}
