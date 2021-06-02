package com.qhala.backend.services;

import com.qhala.backend.exceptions.ResourceNotFoundException;
import com.qhala.backend.models.Books;
import com.qhala.backend.models.MediaFiles;
import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.BooksRepository;
import com.qhala.backend.repositories.MediaRepository;
import com.qhala.backend.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BooksRepository booksRepository;
    private final MediaRepository mediaRepository;
    private  final UsersService usersService;

    @Transactional
    public Books createNewBooks(Long userId, Books books) throws ResourceNotFoundException {
     Users user = usersService.findUserById(userId);
     if (user != null);
     books.setUsers(user);
     return booksRepository.save(books);
    }


    @Transactional
    public MediaFiles createNewMedias(Long userId, MediaFiles mediaFiles) throws ResourceNotFoundException {
        Users user = usersService.findUserById(userId);
        if (user != null);
        mediaFiles.setUsers(user);
        return mediaRepository.save(mediaFiles);
    }

}
