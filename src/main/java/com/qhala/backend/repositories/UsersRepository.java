package com.qhala.backend.repositories;

import com.qhala.backend.exceptions.EAuthException;
import com.qhala.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository  extends JpaRepository<Users, Long> {

    Users findByEmailAndPassword(String email, String password) throws EAuthException;

    Optional<Users> findByEmail(String email);
}
