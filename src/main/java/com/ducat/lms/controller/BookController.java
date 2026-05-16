package com.ducat.lms.controller;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;
import com.ducat.lms.entity.Book;
import com.ducat.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookOutputDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookOutputDto>> getAllBooks() {

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/addBook")
    public ResponseEntity<BookOutputDto> addBook(@RequestBody BookInputDto bookInputDto) {
        return new ResponseEntity<>(bookService.addBook(bookInputDto), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookOutputDto> updateBookById(@PathVariable Long id, @RequestBody BookInputDto bookInputDto) {
        return new ResponseEntity<>(bookService.updateBookById(id, bookInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.removeBook(id), HttpStatusCode.valueOf(200));
    }

}