package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.AnswerOptionEntity;
import nk.trainings.backend.repository.AnswerOptionRepository;
import nk.trainings.backend.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AnswerOptionServiceImpl implements AnswerOptionService {
    @Autowired
    AnswerOptionRepository answerOptionRepository;

    @Override
    public Iterable<AnswerOptionEntity> findAll() {
        return answerOptionRepository.findAll();
    }

    @Override
    public Optional<AnswerOptionEntity> findById(Long id) {
        return answerOptionRepository.findById(id);
    }

    @Override
    public AnswerOptionEntity save(@RequestBody AnswerOptionEntity answerOptionEntity) {
        return answerOptionRepository.save(answerOptionEntity);
    }

    @Override
    public void deleteById(Long id) {
        answerOptionRepository.deleteById(id);
    }
}
