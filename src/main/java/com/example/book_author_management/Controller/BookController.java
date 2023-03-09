package com.example.book_author_management.Controller;

import com.example.book_author_management.DTO.BookDTO;
import com.example.book_author_management.Entity.BookEntity;
import com.example.book_author_management.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody BookDTO bookDTO){
        try{
            String result = bookService.addBook(bookDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBook")
    public BookEntity getBook(@RequestParam("bookId")Integer bookId){
        BookEntity bookEntity = bookService.getBook(bookId);
        return bookEntity;
    }

    @DeleteMapping("/deleteBook")
    public String delelteBook(@RequestParam("bookId") Integer bookId){
        return bookService.deleteBook(bookId);
    }
}
