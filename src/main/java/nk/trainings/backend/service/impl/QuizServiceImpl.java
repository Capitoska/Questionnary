package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.QuizEntity;
import nk.trainings.backend.repository.QuizRepository;
import nk.trainings.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Override
    public Iterable<QuizEntity> findALL() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<QuizEntity> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public QuizEntity save(@RequestBody QuizEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    @Override
    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }
}
