package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users {

    @JsonIgnore
    private Long userId;


    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "email")
    @Email(message="Must be a valid email")
    private String email;


    @JsonProperty(value = "password")
    private String password;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
