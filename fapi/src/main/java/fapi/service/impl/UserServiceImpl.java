package fapi.service.impl;

import fapi.dto.QuizDto;
import fapi.dto.UserDto;
import fapi.dto.converter.QuizConverter;
import fapi.dto.converter.UserConverter;
import fapi.entity.QuizEntity;
import fapi.entity.UserEntity;
import fapi.security.JwtUserFactory;
import fapi.service.RoleService;
import fapi.service.UserService;
import fapi.utils.AuthorizationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("defaultUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${backend.server.url}" + "${backend.users.url}")
    private String backendUserUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RoleService roleService;

    @Autowired
    private QuizConverter quizConverter;

    @Autowired
    private AuthorizationBean authorizationBean;

    @Autowired
    private UserConverter userConverter;

    @Override
    public Iterable<UserDto> findALL() {
        UserEntity[] userEntity = restTemplate.getForObject(backendUserUrl, UserEntity[].class);
        return userEntity == null ? null : userConverter.toDtoList(Arrays.stream(userEntity).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = restTemplate.getForObject(backendUserUrl + id, UserEntity.class);
        return Optional.ofNullable(userConverter.toDto(userEntity));
    }

    @Override
    public UserDto save(UserDto dto) {
        dto.setRole(roleService.findById(3L).get());
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = userConverter.toEntity(dto);

        restTemplate.postForObject(backendUserUrl, userEntity, UserEntity.class);
        return userConverter.toDto(userEntity);
    }

    public UserDto findByUsername(String username) {
        UserEntity userEntity = restTemplate.getForObject(backendUserUrl + "login/" + username, UserEntity.class);
        return userConverter.toDto(userEntity);
    }

    @Override
    @PreAuthorize(value = "admin")
    public void deleteById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendUserUrl + id);
    }


    //    todo заполнить загрузку юзера по его юзернэйму
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = findByUsername(username);
        if (userDto == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return JwtUserFactory.create(userConverter.toEntity(userDto));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserDto user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }


    //todo когда будет храниться в spring Security username и id. исправить работу.
    //todo проверку на null сделать!
    @Override
    public List<QuizDto> findAllQuizesByAuthenticateUser() {
        UserEntity userEntity = userConverter.toEntity(authorizationBean.getAuthorizedUserDTO());
        QuizEntity[] quizEntities = restTemplate.getForObject(backendUserUrl + userEntity.getId() + "/quizes/", QuizEntity[].class);

        return quizConverter.toDtoList(Arrays.stream(quizEntities).collect(Collectors.toList()));
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        UserDto user = findByLogin(userName);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
//    }

}
