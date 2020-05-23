package fapi.service.impl;

import fapi.dto.UserAnswerDto;
import fapi.dto.converter.UserAnswerConverter;
import fapi.entity.UserAnswerEntity;
import fapi.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {
    @Value("${backend.server.url}" + "${backend.user-answers.url}")
    private String backendUserAnswerUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserAnswerConverter userAnswerConverter;

    @Override
    public Iterable<UserAnswerDto> findALL() {
        UserAnswerEntity[] userAnswerEntities = restTemplate.getForObject(backendUserAnswerUrl, UserAnswerEntity[].class);
        return userAnswerEntities.length == 0 ? null :
                userAnswerConverter.ToDtoList(Arrays.stream(userAnswerEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserAnswerDto> findById(Long id) {
        UserAnswerEntity userAnswerEntity = restTemplate.getForObject(backendUserAnswerUrl + id, UserAnswerEntity.class);
        return Optional.ofNullable(userAnswerConverter.toDto(userAnswerEntity));
    }

    @Override
    public UserAnswerDto save(UserAnswerDto dto) {
        restTemplate.postForObject(backendUserAnswerUrl, userAnswerConverter.toEntity(dto), UserAnswerEntity.class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendUserAnswerUrl + id);
    }
}

