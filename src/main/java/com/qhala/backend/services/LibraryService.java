package com.qhala.backend.services;

import com.qhala.backend.exceptions.ResourceNotFoundException;
import com.qhala.backend.models.Books;
import com.qhala.backend.models.MediaFiles;
import com.qhala.backend.models.Users;
import com.qhala.backend.repositories.BooksRepository;
import com.qhala.backend.repositories.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public List<Books> getOneLibraryBooks(long userId) throws ResourceNotFoundException {
        Users user = usersService.findUserById(userId);
        return booksRepository.findAll().stream()
                .filter(books -> books.getUsers().getId() == user.getId())
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MediaFiles> getOneLibraryMedias(long userId) throws ResourceNotFoundException {
        Users user = usersService.findUserById(userId);
        return mediaRepository.findAll().stream()
                .filter(mediaFiles -> mediaFiles.getUsers().getId() == user.getId())
                .collect(Collectors.toList());
    }
}
