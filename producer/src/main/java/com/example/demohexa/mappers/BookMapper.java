package com.example.demohexa.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demohexa.data.BookDto;
import com.example.demohexa.entity.Book;

@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	BookDto bookToBookDto(Book book);

	Book bookDtoToBook(BookDto bookDto);

	List<BookDto> bookListToBookDtoList(List<Book> bookList);

	List<Book> BookDtoListTobookList(List<BookDto> BookDtoList);
}
