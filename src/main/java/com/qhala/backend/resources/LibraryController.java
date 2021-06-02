package com.qhala.backend.resources;

import com.qhala.backend.models.Books;
import com.qhala.backend.models.MediaFiles;
import com.qhala.backend.services.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/library")
public class LibraryController {

   private final LibraryService libraryService;

    @PostMapping(value = "/{userId}/books")
    public ResponseEntity<?> addNewBooks(@Valid @RequestBody Books books,
                                         @PathVariable Long userId) throws Exception {
        libraryService.createNewBooks(userId, books);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/{userId}/videos")
    public ResponseEntity<?> addNewBooks(@Valid @RequestBody MediaFiles mediaFiles,
                                          @PathVariable Long userId) throws Exception {
        libraryService.createNewMedias(userId, mediaFiles);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    //Get All Books

    @GetMapping(value = "/books")
    public ResponseEntity<?> getAllBooks(){

    }

    @GetMapping(value = "/videos")
    public ResponseEntity<?> getAllMedias(){

    }




}
