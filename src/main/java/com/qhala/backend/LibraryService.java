package com.qhala.backend;

import com.qhala.backend.repositories.BooksRepository;
import com.qhala.backend.repositories.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BooksRepository booksRepository;
    private final MediaRepository mediaRepository;
}
