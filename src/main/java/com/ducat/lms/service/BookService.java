package com.ducat.lms.service;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;
import com.ducat.lms.entity.Book;

import java.util.List;

public interface BookService {

    BookOutputDto getBook(Long id);
    List<BookOutputDto> getAllBooks();
    BookOutputDto  addBook(BookInputDto bookInputDto);
    BookOutputDto updateBook(Long id, BookInputDto bookInputDto);
    String removeBook(Long id);
}

