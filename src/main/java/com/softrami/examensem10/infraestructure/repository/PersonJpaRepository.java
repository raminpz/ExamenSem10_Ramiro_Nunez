package com.softrami.examensem10.infraestructure.repository;

import com.softrami.examensem10.infraestructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
