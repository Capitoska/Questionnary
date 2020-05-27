package fapi.service.impl;

import fapi.dto.UserAnswerDto;
import fapi.dto.UserDto;
import fapi.dto.converter.UserAnswerConverter;
import fapi.entity.UserAnswerEntity;
import fapi.service.UserAnswerService;
import fapi.utils.AuthorizationBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserAnswerServiceImpl implements UserAnswerService {
    @Value("${backend.server.url}" + "${backend.user-answers.url}")
    private String backendUserAnswerUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    AuthorizationBean authorizationBean;

    @Autowired
    private UserAnswerConverter userAnswerConverter;

    @Override
    public Iterable<UserAnswerDto> findALL() {
        UserAnswerEntity[] userAnswerEntities = restTemplate.getForObject(backendUserAnswerUrl, UserAnswerEntity[].class);
        return userAnswerEntities.length == 0 ? null :
                userAnswerConverter.toDtoList(Arrays.stream(userAnswerEntities).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserAnswerDto> findById(Long id) {
        UserAnswerEntity userAnswerEntity = restTemplate.getForObject(backendUserAnswerUrl + id, UserAnswerEntity.class);
        return Optional.ofNullable(userAnswerConverter.toDto(userAnswerEntity));
    }

    //todo установить метод для вставки зарегистрированного юзера в отвечающего.

    @Override
    public UserAnswerDto save(UserAnswerDto dto) {
        return null;
    }

    @Override
    public List<UserAnswerDto> saveAll(List<UserAnswerDto> dtos) {
        UserDto userDto = authorizationBean.getAuthorizedUserDTO();
        log.info("SaveAll is worked");
        dtos.stream().forEach(dto->dto.setUser(userDto));
        restTemplate.postForObject(backendUserAnswerUrl, userAnswerConverter.toEntityList(dtos), UserAnswerEntity[].class);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(backendUserAnswerUrl + id);
    }
}

