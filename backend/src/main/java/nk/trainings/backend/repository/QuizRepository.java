package nk.trainings.backend.repository;

import nk.trainings.backend.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    Iterable<QuizEntity> findAllByName(String name);
    Iterable<QuizEntity> findAllByAuthor_Id(Long id);
}
