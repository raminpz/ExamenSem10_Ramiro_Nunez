package com.softrami.examensem10.application.useCase;

import com.softrami.examensem10.domain.model.User;
import com.softrami.examensem10.domain.port.in.UserUseCase;
import com.softrami.examensem10.domain.port.out.UserRepositoryPort;

import java.util.Map;
import java.util.Optional;

public class UserUseCaseImpl implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User crearUsuario(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> getUsuario(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public Optional<User> updateUsuario(Long id, User user) {
        return userRepositoryPort.update(id,user);
    }

    @Override
    public boolean deleteUserio(Long id) {
        return userRepositoryPort.deleteById(id);
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return userRepositoryPort.loginWithUser(requestMap);
    }
}
