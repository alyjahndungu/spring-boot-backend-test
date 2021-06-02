package com.qhala.backend.resources;

import com.qhala.backend.models.Books;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/library")
public class LibraryController {

   private final LibraryService libraryService;

    @PostMapping(value = "/{userId}/books")
    public ResponseEntity addNewBooks(@Valid @RequestBody Books books,
                                           @PathVariable Long userId) throws Exception {
        libraryService.createNewBooks(userId, books);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
