package com.example.book_author_management.Service;

import com.example.book_author_management.Converter.AuthorDTOtoEntityConvertor;
import com.example.book_author_management.DTO.AuthorDTO;
import com.example.book_author_management.DTO.AuthorRequestDTO;
import com.example.book_author_management.Entity.AuthorEntity;
import com.example.book_author_management.Entity.BookEntity;
import com.example.book_author_management.Repository.AuthorRepository;
import com.example.book_author_management.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addAuthor(AuthorDTO authorDTO){
        AuthorEntity authorEntity = AuthorDTOtoEntityConvertor.authorDTOtoEntityConvertor(authorDTO);
        authorRepository.save(authorEntity);
        return "Author added successfully.";
    }

    public AuthorEntity getAuthor(int authorId){
        return authorRepository.findById(authorId).get();
    }

    public String updateRating (AuthorRequestDTO authorDTO){

        AuthorEntity originalAuthor = authorRepository.findById(authorDTO.getId()).get();
        originalAuthor.setRating(authorDTO.getRating());
        authorRepository.save(originalAuthor);

        return "Author updated successfully.";

    }

    public String deleteAuthor(Integer authorId){
        AuthorEntity authorEntity = authorRepository.findById(authorId).get();
        List<BookEntity>bookEntityList = authorEntity.getBooksWrittenList();
        for(BookEntity b : bookEntityList){
            bookRepository.delete(b);
        }
        authorRepository.delete(authorEntity);
        return "Author deleted successfully.";
    }
}
