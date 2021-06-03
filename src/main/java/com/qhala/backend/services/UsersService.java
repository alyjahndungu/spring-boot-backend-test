package com.qhala.backend.services;

import com.qhala.backend.exceptions.EAuthException;
import com.qhala.backend.exceptions.ResourceNotFoundException;
import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @Transactional
    public Users registerUser(@Valid @RequestBody Users users) throws EAuthException {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);

    }

    @Transactional
    public Users findUserById(long userId) throws ResourceNotFoundException {
        return usersRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("No User Record Found::"+ userId));
    }
}
