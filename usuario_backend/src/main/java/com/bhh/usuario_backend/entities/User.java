package com.bhh.usuario_backend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "Users")
public class User implements Serializable {

    @Id
    private String id;
    private String userName;
    private String lastName;

    @DBRef
    private Role role;
}
