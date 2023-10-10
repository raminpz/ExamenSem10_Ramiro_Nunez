package com.softrami.examensem10.domain.port.out;

import com.softrami.examensem10.domain.model.User;

import java.util.Map;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> update(Long id, User user);
    boolean deleteById(Long id);

    String loginWithUser(Map<String, String> requestMap);
}
