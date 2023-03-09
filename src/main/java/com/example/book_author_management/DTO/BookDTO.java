package com.example.book_author_management.DTO;

import com.example.book_author_management.Enum.Genre;
import com.example.book_author_management.Enum.Language;
import lombok.Data;

@Data
public class BookDTO {

    private String bookName;
    private Genre genre;
    private Language language;
    private int authorId;

}
