package com.softrami.examensem10.infraestructure.config;

import com.softrami.examensem10.application.service.PersonService;
import com.softrami.examensem10.application.service.UserService;
import com.softrami.examensem10.application.useCase.PersonUseCaseImpl;
import com.softrami.examensem10.application.useCase.UserUseCaseImpl;
import com.softrami.examensem10.domain.port.out.PersonRepositoryPort;
import com.softrami.examensem10.domain.port.out.UserRepositoryPort;
import com.softrami.examensem10.infraestructure.repository.PersonJpaRepositoryAdapter;
import com.softrami.examensem10.infraestructure.repository.UserJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PersonService personService(PersonRepositoryPort personRepositoryPort){
        return new PersonService( new PersonUseCaseImpl(personRepositoryPort));
    }
    @Bean
    public PersonRepositoryPort personRepositoryPort(PersonJpaRepositoryAdapter personJpaRepositoryAdapter){
        return personJpaRepositoryAdapter;

    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(new UserUseCaseImpl(userRepositoryPort));
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(UserJpaRepositoryAdapter userJpaRepositoryAdapter){
        return userJpaRepositoryAdapter;
    }


}
