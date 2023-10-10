package com.softrami.examensem10.domain.port.in;

import com.softrami.examensem10.domain.model.User;

import java.util.Map;
import java.util.Optional;

public interface UserUseCase {
    User crearUsuario(User user);
    Optional<User> getUsuario(Long id);
    Optional<User> updateUsuario(Long id, User user);
    boolean deleteUserio(Long id);

    String loginWithUser(Map<String, String> requestMap);


}
