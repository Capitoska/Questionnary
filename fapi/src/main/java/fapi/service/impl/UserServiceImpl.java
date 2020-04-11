package fapi.service.impl;

import fapi.dto.UserDto;
import fapi.dto.converter.UserConverter;
import fapi.entity.UserEntity;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}" + "${backend.users.url}")
    private String backendUserUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserConverter userConverter;

    @Override
    public Iterable<UserDto> findALL() {
        UserEntity []userEntity = restTemplate.getForObject(backendUserUrl, UserEntity[].class);
        return userEntity.length == 0 ?null: userConverter.ToDtoList(Arrays.stream(userEntity).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = restTemplate.getForObject(backendUserUrl + id, UserEntity.class);
        return Optional.ofNullable(userConverter.toDto(userEntity));
    }

    @Override
    public UserDto save(UserDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = userConverter.toEntity(dto);
        restTemplate.postForObject(backendUserUrl,userEntity,UserEntity.class);
        return userConverter.toDto(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendUserUrl + id);
    }
}
