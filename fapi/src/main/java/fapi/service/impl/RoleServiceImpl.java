package fapi.service.impl;

import fapi.dto.RoleDto;
import fapi.dto.converter.RoleConverter;
import fapi.entity.RoleEntity;
import fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RoleConverter roleConverter;

    @Value("${backend.server.url}" + "${backend.role.url}")
    private String backendRoleUrl;

    @Override
    public Iterable<RoleDto> findALL() {
        return null;
    }

    public Optional<RoleDto> findById(Long id) {
        RoleEntity roleEntity = restTemplate.getForObject(backendRoleUrl + id, RoleEntity.class);
        return Optional.ofNullable(roleConverter.toDto(roleEntity));
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
