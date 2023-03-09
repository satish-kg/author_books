package com.example.book_author_management.Converter;

import com.example.book_author_management.DTO.AuthorDTO;
import com.example.book_author_management.Entity.AuthorEntity;

public class AuthorDTOtoEntityConvertor {

    public static AuthorEntity authorDTOtoEntityConvertor(AuthorDTO authorDTO){

        AuthorEntity authorEntity = AuthorEntity.builder()
                .name(authorDTO.getName())
                .age(authorDTO.getAge())
                .rating(authorDTO.getRating())
                .build();

        return authorEntity;
    }
}
