package com.qhala.backend.resources;

import com.qhala.backend.models.AuthResponse;
import com.qhala.backend.models.UserDTO;
import com.qhala.backend.services.MyDetailsUserService;
import com.qhala.backend.services.UsersService;
import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.UsersRepository;
import com.qhala.backend.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")

public class UserController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;
    private final MyDetailsUserService myDetailsUserService;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }

        final UserDetails userDetails = myDetailsUserService.loadUserByUsername(userDTO.getEmail());
        final String jwtToken = jwtUtils.generateToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        System.out.println(jwtToken);
        return ResponseEntity.ok(new AuthResponse(jwtToken,
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Users users) {
        Optional<Users> u = usersRepository.findByEmail(users.getEmail());
        if(u.isPresent()){
            return new ResponseEntity("Email is already taken!!!!!", HttpStatus.BAD_REQUEST);
        }
        usersService.registerUser(users);

        return new ResponseEntity("New user created successfully", HttpStatus.CREATED);
    }


}
