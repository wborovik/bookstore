package com.example.bookstore.mapper;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
//    @Mapping(target = "genreId", source = "genre.id")
//    @Mapping(target = "authorId", source = "author.id")
//    BookDTO bookToBookDTO(Book book);

    @Mapping(target = "genre.id", source = "genreId")
    @Mapping(target = "author.id", source = "authorId")
    Book bookDtoToBook(BookDto bookDto);
}
