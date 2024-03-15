package com.bhh.usuario_backend.controllers;

import com.bhh.usuario_backend.entities.Role;
import com.bhh.usuario_backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired private RoleService service;

    //Create a new role
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> createRole(@RequestBody Role entity){
        Role newEntity = service.createRole(entity);
        return new ResponseEntity<Role>(newEntity, HttpStatus.CREATED);
    }

    //Get role by id
    @GetMapping(path = "/{entityId}",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRoleById(@PathVariable String entityId){
        Role entityFound = service.getRoleById(entityId);
        return new ResponseEntity<Role>(entityFound, HttpStatus.OK);
    }

    //Get all roles
    @GetMapping(produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> entityList = service.getAllRoles();
        return new ResponseEntity<List<Role>>(entityList, HttpStatus.OK);
    }

    //Update role
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> updateRole(@RequestBody Role entity){
        Role entityUpdated = service.updateRole(entity);
        return new ResponseEntity<Role>(entityUpdated, HttpStatus.ACCEPTED);
    }

    //Delete role
    @DeleteMapping(path = "/{entityId}")
    public ResponseEntity<Object> deleteRole(@PathVariable String entityId){
        service.deleteRole(entityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
