package com.qhala.backend.models;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private  String password;
}
