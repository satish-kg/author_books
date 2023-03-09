package com.example.book_author_management.Service;

import com.example.book_author_management.Converter.BookDTOtoEntityConvertor;
import com.example.book_author_management.DTO.BookDTO;
import com.example.book_author_management.Entity.AuthorEntity;
import com.example.book_author_management.Entity.BookEntity;
import com.example.book_author_management.Repository.AuthorRepository;
import com.example.book_author_management.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookDTO bookDTO){
        BookEntity bookEntity = BookDTOtoEntityConvertor.bookDTOtoEntityConvertor(bookDTO);

        int authorId = bookDTO.getAuthorId();
        AuthorEntity authorEntity = authorRepository.findById(authorId).get();
        bookEntity.setAuthorEntity(authorEntity);
        bookRepository.save(bookEntity);
        List<BookEntity> bookEntityList = authorEntity.getBooksWrittenList();
        bookEntityList.add(bookEntity);
        authorRepository.save(authorEntity);
        return "Book added successfully.";
    }

    public BookEntity getBook(int bookId){
        return bookRepository.findById(bookId).get();
    }

    public String deleteBook(int bookId){
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        AuthorEntity authorEntity = bookEntity.getAuthorEntity();
        List<BookEntity> bookEntityList = authorEntity.getBooksWrittenList();
        bookEntityList.remove(bookEntity);
        authorRepository.save(authorEntity);
        bookRepository.delete(bookEntity);
        return "Book deleted successfully.";
    }
}
