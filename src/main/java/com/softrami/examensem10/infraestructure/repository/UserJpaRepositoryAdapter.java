package com.softrami.examensem10.infraestructure.repository;

import com.softrami.examensem10.domain.model.User;
import com.softrami.examensem10.domain.port.out.UserRepositoryPort;
import com.softrami.examensem10.infraestructure.entity.UserEntity;
import com.softrami.examensem10.infraestructure.security.CustomerDetailService;
import com.softrami.examensem10.infraestructure.security.Jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class UserJpaRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;
    private final CustomerDetailService customerDetailService;
    public UserJpaRepositoryAdapter(UserJpaRepository userJpaRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomerDetailService customerDetailService) {
        this.userJpaRepository = userJpaRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customerDetailService = customerDetailService;
    }


    public String loginWithUser(Map<String, String> requestMap){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("usuario"), requestMap.get("password")));
            if(authentication.isAuthenticated()){
                String token_generado = jwtUtil.generateToken(
                        customerDetailService.getUserDetail().getUsuario(),
                        customerDetailService.getUserDetail().getPassword()
                );
                return token_generado;
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }



    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        UserEntity saveUserEntity = userJpaRepository.save(userEntity);
        return saveUserEntity.toDomainModel();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserEntity::toDomainModel);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        if (userJpaRepository.existsById(user.getId())){
            UserEntity userEntity = UserEntity.fromDomainModel(user);
            UserEntity updateuserEntity = userJpaRepository.save(userEntity);
            return Optional.of(updateuserEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (userJpaRepository.existsById(id)){
            userJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
