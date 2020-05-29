package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.UserAnswerEntity;
import nk.trainings.backend.repository.UserAnswerRepository;
import nk.trainings.backend.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

//todo сохранение ответа ТЕКСТ продумать. 

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Override
    public Iterable<UserAnswerEntity> findAll() {
        return userAnswerRepository.findAll();
    }

    @Override
    public Optional<UserAnswerEntity> findById(Long id) {
        return userAnswerRepository.findById(id);
    }

    @Override
    public UserAnswerEntity save(@RequestBody UserAnswerEntity userAnswerEntity) {
        return userAnswerRepository.save(userAnswerEntity);
    }

    //TODO ГОВНОООООООО
    @Override
    public List<UserAnswerEntity> saveAll(@RequestBody List<UserAnswerEntity> userAnswerEntities){
        for(UserAnswerEntity userAnswerEntity:userAnswerEntities){
            if(userAnswerEntity.getQuestion().getAnswerType().getValue().equals("")){}
        }
        return (List<UserAnswerEntity>) userAnswerRepository.saveAll(userAnswerEntities);
    }

    @Override
    public void deleteById(Long id) {
        userAnswerRepository.deleteById(id);
    }
}
