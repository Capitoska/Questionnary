package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.QuestionEntity;
import nk.trainings.backend.repository.QuestionRepository;
import nk.trainings.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Iterable<QuestionEntity> findALL() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<QuestionEntity> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public QuestionEntity save(@RequestBody QuestionEntity questionEntity) {
        return questionRepository.save(questionEntity);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
