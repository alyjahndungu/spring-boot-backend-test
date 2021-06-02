package com.qhala.backend.services;

import com.qhala.backend.exceptions.EAuthException;
import com.qhala.backend.exceptions.ResourceNotFoundException;
import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    

    @Transactional
    public Users validateUser(String email, String password) throws EAuthException {
        if(email != null) email = email.toLowerCase();
        return usersRepository.findByEmailAndPassword(email, password);
    }

    @Transactional
    public Users registerUser(@Valid @RequestBody Users users) throws EAuthException {
        return usersRepository.save(users);

    }

    @Transactional
    public Users findUserById(long userId) throws ResourceNotFoundException {
        return usersRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("No User Record Found::"+ userId));
    }
}
