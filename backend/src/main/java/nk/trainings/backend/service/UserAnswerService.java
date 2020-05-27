package nk.trainings.backend.service;

import nk.trainings.backend.entity.UserAnswerEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserAnswerService extends DefaultService<UserAnswerEntity> {
    public List<UserAnswerEntity> saveAll(@RequestBody List<UserAnswerEntity> userAnswerEntities);
}
