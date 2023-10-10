package com.softrami.examensem10.infraestructure.controller;

import com.softrami.examensem10.application.service.UserService;
import com.softrami.examensem10.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createUser = userService.crearUsuario(user);

        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        return userService.getUsuario(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{personaId}")
    public ResponseEntity<User> updateUser(@PathVariable Long personaId, @RequestBody User user){
        return userService.updateUsuario(personaId,user)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{personaId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long personaId){
        if (userService.deleteUserio(personaId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public String loginWithUser(@RequestBody(required = true) Map<String, String> requestMap){
        return userService.loginWithUser(requestMap);
    }
}
