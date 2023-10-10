package com.softrami.examensem10.infraestructure.repository;

import com.softrami.examensem10.infraestructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByNombreUsuario(String nombreUsuario);
}
