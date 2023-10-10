package com.softrami.examensem10.application.service;

import com.softrami.examensem10.domain.model.User;
import com.softrami.examensem10.domain.port.in.UserUseCase;

import java.util.Map;
import java.util.Optional;

public class UserService implements UserUseCase {

    private final UserUseCase userUseCase;

    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public User crearUsuario(User user) {
        return userUseCase.crearUsuario(user);
    }

    @Override
    public Optional<User> getUsuario(Long id) {
        return userUseCase.getUsuario(id);
    }

    @Override
    public Optional<User> updateUsuario(Long id, User user) {
        return userUseCase.updateUsuario(id,user);
    }

    @Override
    public boolean deleteUserio(Long id) {
        return userUseCase.deleteUserio(id);
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return userUseCase.loginWithUser(requestMap);
    }
}
