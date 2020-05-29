package nk.trainings.backend.service.impl;

import nk.trainings.backend.entity.UserEntity;
import nk.trainings.backend.repository.RoleRepository;
import nk.trainings.backend.repository.UserRepository;
import nk.trainings.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }


    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
