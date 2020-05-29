package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.ReportEntity;
import nk.trainings.backend.repository.ReportRepository;
import nk.trainings.backend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Iterable findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public ReportEntity save(ReportEntity entity) {
        return reportRepository.save(entity);
    }

    @Override
    public Iterable<ReportEntity> findAllByQuizId(Long quizId){
        return reportRepository.getAllByQuiz_Id(quizId);
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
