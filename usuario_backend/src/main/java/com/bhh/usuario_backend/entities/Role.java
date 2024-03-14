package com.bhh.usuario_backend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "Roles")
public class Role implements Serializable {

    @Id
    private String id;
    private String roleName;
}
