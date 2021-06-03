package com.qhala.backend.services;

import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyDetailsUserService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        final Optional<Users> user = usersRepository.findByEmail(email);
        if (!user.isPresent()){
            throw new UsernameNotFoundException("Email was not found" + email);
        }
        UserDetails username = User.withUsername(user.get().getEmail()).password(user.get().getPassword())
                .authorities("ROLE_USER").build();
        return username;
    }

}
