package com.bhh.usuario_backend.services;

import com.bhh.usuario_backend.entities.Role;
import com.bhh.usuario_backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired private RoleRepository repository;

    //Create a new role:
    public Role createRole(Role entity) {
        return repository.save(entity);
    }

    //Return role by id when exists or null if doesn't exist
    public Role getRoleById(String id){
        return repository.findById(id).orElse(null);
    }

    //Retrieve all roles from db
    public List<Role> getAllRoles(){
        return repository.findAll();
    }

    //Update an existing role in db
    public Role updateRole(Role entity){
        return repository.save(entity);
    }

    //Delete an existing role in db
    public void deleteRole(String id){
        repository.deleteById(id);
    }
}
