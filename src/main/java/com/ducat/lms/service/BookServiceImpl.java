package com.ducat.lms.service;

import com.ducat.lms.dto.BookInputDto;
import com.ducat.lms.dto.BookOutputDto;
import com.ducat.lms.entity.Book;
import com.ducat.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookOutputDto getBook(Long id) {
        Book bookEntity = bookRepository.findById(id).orElse(null);

        BookOutputDto bookOutputDto = new BookOutputDto();

        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    // This method returns a list of BookOutputDto Objects
    public List<BookOutputDto> getAllBooks() {

        /*  bookRepository.findAll(); -> fetch all he record from book table in the database
         and stored in list of Book Entities */
        List<Book> bookEntities = bookRepository.findAll();

        // This list will store all the converted BookOutputDto Objects or Prepare Output List
        List<BookOutputDto> booksOutputDto = new ArrayList<>();

        // Iterate through each book entity retrieved from the database
        for(Book bookEntity : bookEntities) {

            // Converting Entity to DTO
            BookOutputDto bookOutputDto = new BookOutputDto();
            bookOutputDto.setId(bookEntity.getId());
            bookOutputDto.setName(bookEntity.getName());
            bookOutputDto.setAuthor(bookEntity.getAuthor());
            bookOutputDto.setPrice(bookEntity.getPrice());

            // The constructed DTo is added to the final Outout List
            booksOutputDto.add(bookOutputDto);
        }

        // Return the list of DTOs
        return booksOutputDto;
    }


    @Override
    public BookOutputDto addBook(BookInputDto bookInputDto) {

        Book bookEntity = new Book();

        bookEntity.setName(bookInputDto.getName());
        bookEntity.setAuthor(bookInputDto.getAuthor());
        bookEntity.setPrice(bookInputDto.getPrice());

        bookEntity = bookRepository.save(bookEntity);

        BookOutputDto bookOutputDto = new BookOutputDto();
        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    public BookOutputDto updateBook(Long id, BookInputDto bookInputDto) {
        Book bookEntity = new Book();
        bookEntity.setId(id);
        bookEntity.setName(bookInputDto.getName());
        bookEntity.setAuthor(bookInputDto.getAuthor());
        bookEntity.setPrice(bookInputDto.getPrice());

        bookEntity = bookRepository.save(bookEntity);

        BookOutputDto bookOutputDto = new BookOutputDto();
        bookOutputDto.setId(bookEntity.getId());
        bookOutputDto.setName(bookEntity.getName());
        bookOutputDto.setAuthor(bookEntity.getAuthor());
        bookOutputDto.setPrice(bookEntity.getPrice());

        return bookOutputDto;
    }

    @Override
    public String removeBook(Long id) {
        bookRepository.deleteById(id);
        return "Book id: " + id + " successfully removed.";
    }
}












