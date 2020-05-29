package fapi.service;

import fapi.dto.ReportDto;

public interface ReportService extends DefaultService<ReportDto>  {
    public Iterable<ReportDto> findAllByQuizId(Long quizId);
}
