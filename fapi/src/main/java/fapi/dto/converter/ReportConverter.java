package fapi.dto.converter;

import fapi.dto.ReportDto;
import fapi.entity.ReportEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportConverter implements DefaultConverter<ReportDto, ReportEntity> {

    @Autowired
    ModelMapper mapper;

    @Override
    public ReportDto toDto(ReportEntity reportEntity) {
        return reportEntity == null ? null : mapper.map(reportEntity, ReportDto.class);
    }

    @Override
    public ReportEntity toEntity(ReportDto reportDto) {
        return reportDto == null ? null : mapper.map(reportDto, ReportEntity.class);
    }
}
