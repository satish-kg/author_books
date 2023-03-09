package com.example.book_author_management.Controller;


import com.example.book_author_management.DTO.AuthorDTO;
import com.example.book_author_management.DTO.AuthorRequestDTO;
import com.example.book_author_management.Entity.AuthorEntity;
import com.example.book_author_management.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody AuthorDTO authorDTO){
        try{
            String result = authorService.addAuthor(authorDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAuthor")
    public AuthorEntity getAuthor(@RequestParam("authorId") Integer authorId){
        return authorService.getAuthor(authorId);
    }

    @PutMapping("/updateRating")
    public String updateRating(@RequestBody AuthorRequestDTO authorDTO){
        String result = authorService.updateRating(authorDTO);
        return result;
    }

    @DeleteMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("authorId") Integer authorId){
        String result = authorService.deleteAuthor(authorId);
        return result;
    }

}
