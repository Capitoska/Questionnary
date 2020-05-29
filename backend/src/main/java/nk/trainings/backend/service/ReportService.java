package nk.trainings.backend.service;

import nk.trainings.backend.entity.ReportEntity;

public interface ReportService extends DefaultService<ReportEntity> {
    public Iterable<ReportEntity> findAllByQuizId(Long quizId);
}
