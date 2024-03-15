package com.bhh.usuario_backend.controllers;

import com.bhh.usuario_backend.entities.User;
import com.bhh.usuario_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;

    //Create new user
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User entity){
        User newEntity = service.createUser(entity);
        return new ResponseEntity<User>(newEntity, HttpStatus.CREATED);
    }

    //Get user by id
    @GetMapping(path = "=/{entityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable String entityId){
        User userFound = service.getUserById(entityId);
        return new ResponseEntity<User>(userFound, HttpStatus.OK);
    }

    //Get all users
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = service.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    //update user
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User entity){
        User entityUpdated = service.updateUser(entity);
        return new ResponseEntity<User>(entityUpdated,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUser (@PathVariable String id){
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

