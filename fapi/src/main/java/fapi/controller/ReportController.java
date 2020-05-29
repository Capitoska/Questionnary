package fapi.controller;


import fapi.dto.ReportDto;
import fapi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fapi/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ReportDto> getReportById(@PathVariable Long id) {
        ReportDto reportDto = reportService.findById(id).get();
        return ResponseEntity.ok(reportDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<ReportDto>> getAllReports() {
        List<ReportDto> reportDtos = (List<ReportDto>) reportService.findALL();
        return ResponseEntity.ok(reportDtos);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReportDto> save(@RequestBody ReportDto dto) {
        dto = reportService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        reportService.deleteById(id);
    }

    @RequestMapping(value = "quizes/{id}",method = RequestMethod.GET)
    public ResponseEntity<Iterable<ReportDto>> getAllByQuizId(@PathVariable Long id){
        List<ReportDto> reportDtos = (List<ReportDto>)reportService.findAllByQuizId(id);
        return ResponseEntity.ok(reportDtos);
    }
}
