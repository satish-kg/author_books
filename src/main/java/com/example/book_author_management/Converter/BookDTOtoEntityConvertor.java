package com.example.book_author_management.Converter;

import com.example.book_author_management.DTO.BookDTO;
import com.example.book_author_management.Entity.BookEntity;

public class BookDTOtoEntityConvertor {

    public static BookEntity bookDTOtoEntityConvertor(BookDTO bookDTO){

        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookDTO.getBookName())
                .genre(bookDTO.getGenre())
                .language(bookDTO.getLanguage())
                .build();
        return bookEntity;

    }
}
