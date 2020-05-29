package fapi.service.impl;

import fapi.dto.ReportDto;
import fapi.dto.converter.ReportConverter;
import fapi.entity.ReportEntity;
import fapi.service.ReportService;
import fapi.utils.AuthorizationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Value("${backend.server.url}" + "${backend.report.url}")
    private String backendReportUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ReportConverter reportConverter;

    @Autowired
    AuthorizationBean authorizationBean;

    @Override
    public Iterable<ReportDto> findALL() {
        ReportEntity[] reportEntities = restTemplate.getForObject(backendReportUrl, ReportEntity[].class);
        return reportEntities.length == 0 ? null :
                reportConverter.toDtoList(Arrays.stream(reportEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<ReportDto> findById(Long id) {
        ReportEntity reportEntity = restTemplate.getForObject(backendReportUrl + id, ReportEntity.class);
        return Optional.ofNullable(reportConverter.toDto(reportEntity));
    }

    @Override
    public ReportDto save(ReportDto dto) {
        dto.setReporter(authorizationBean.getAuthorizedUserDTO());
        restTemplate.postForObject(backendReportUrl, reportConverter.toEntity(dto), ReportEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendReportUrl + id);
    }

    @Override
    public Iterable<ReportDto> findAllByQuizId(Long quizId) {
        ReportEntity[] reportEntityList = restTemplate.getForObject(backendReportUrl + "quizes/" + quizId,
                ReportEntity[].class);
        return reportEntityList.length == 0 ? null :
                reportConverter.toDtoList(Arrays.stream(reportEntityList).collect(Collectors.toList()));
    }
}
