package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.AnswerTypeEntity;
import nk.trainings.backend.repository.AnswerTypeRepository;
import nk.trainings.backend.service.AnswerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AnswerTypeServiceImpl implements AnswerTypeService {

    @Autowired
    AnswerTypeRepository answerTypeRepository;

    @Override
    public Iterable<AnswerTypeEntity> findAll() {
        return answerTypeRepository.findAll();
    }

    @Override
    public Optional<AnswerTypeEntity> findById(Long id) {
        return answerTypeRepository.findById(id);
    }

    @Override
    public AnswerTypeEntity save(@RequestBody AnswerTypeEntity answerTypeEntity) {
        return answerTypeRepository.save(answerTypeEntity);
    }

    @Override
    public void deleteById(Long id) {
        answerTypeRepository.deleteById(id);
    }

    @Override
    public Optional<AnswerTypeEntity> findByValue(String value) {
        return answerTypeRepository.findByValue(value);
    }
}
