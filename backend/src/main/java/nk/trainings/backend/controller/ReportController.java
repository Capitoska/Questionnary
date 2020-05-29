package nk.trainings.backend.controller;

import nk.trainings.backend.entity.ReportEntity;
import nk.trainings.backend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/reports")
public class ReportController {

    @Autowired
    ReportService reportService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ReportEntity> getUserAnswerById(@PathVariable(name = "id") Long id) {
        Optional<ReportEntity> reportEntity = reportService.findById(id);
        return reportEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ReportEntity> getAllReport() {
        return reportService.findAll();
    }


    @RequestMapping(value = "/quizes/{id}", method = RequestMethod.GET)
    public Iterable<ReportEntity> getAllReportByQuizId(@PathVariable(name = "id") Long id) {
        return reportService.findAllByQuizId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReportEntity save(@RequestBody ReportEntity reportEntity) {
        return reportService.save(reportEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        reportService.deleteById(id);
    }


}
