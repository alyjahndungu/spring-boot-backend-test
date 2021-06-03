package com.qhala.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class AuthResponse {
    private final String jwtToken;
    private final  String username;
    private final List<String> authorities;
    @JsonIgnore
    private  String password;

    public AuthResponse(String jwtToken, String username, List<String> authorities) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.authorities = authorities;
    }

    public String getJwt(){
        return jwtToken;
    }
}
