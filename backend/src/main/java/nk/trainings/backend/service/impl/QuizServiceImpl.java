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
    public Iterable<QuizEntity> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<QuizEntity> findById(Long id) {
        return quizRepository.findById(id);
    }

    public QuizEntity update(QuizEntity quizEntity){
        return quizRepository.save(quizEntity);
    }

//    public QuizEntity generateUrlAddress(QuizEntity quizEntity){
//        Random random = new Random();
//        String newUrlAddress = null;
//        try {
//            newUrlAddress = base64Bean.encodeString(quizEntity.getId()+
//                    quizEntity.getName() + random.nextInt(1_000_000));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        quizEntity.setUrlAdress(newUrlAddress);
//        return quizRepository.save(quizEntity);
//    }

    @Override
    public QuizEntity save(@RequestBody QuizEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    @Override
    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Iterable<QuizEntity> findByName(String name) {
        return quizRepository.findAllByName(name);
    }

    @Override
    public Iterable<QuizEntity> findAllByAuthor_Id(Long id) {
        return quizRepository.findAllByAuthor_Id(id);
    }
}
