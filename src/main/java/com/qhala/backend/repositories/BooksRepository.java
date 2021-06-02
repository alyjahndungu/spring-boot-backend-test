package com.qhala.backend.repositories;

import com.qhala.backend.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {


}
