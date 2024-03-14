package com.bhh.usuario_backend.services;

import com.bhh.usuario_backend.entities.User;
import com.bhh.usuario_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepository repository;

    //Create a new User:
    public User createUser(User entity) {
        return repository.save(entity);
    }

    //Return User by id when exists or null if doesn't exist
    public User getUserById(String id){
        return repository.findById(id).orElse(null);
    }

    //Retrieve all Users from db
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //Update an existing User in db
    public User updateUser(User entity){
        return repository.save(entity);
    }

    //Delete an existing User in db
    public void deleteUser(String id){
        repository.deleteById(id);
    }
}
