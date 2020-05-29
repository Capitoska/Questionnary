package nk.trainings.backend.repository;

import nk.trainings.backend.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    Iterable<QuizEntity> findAllByName(String name);
    Iterable<QuizEntity> findAllByAuthor_Id(Long id);
    Optional<QuizEntity> findByUrlAddress(String url);
}
