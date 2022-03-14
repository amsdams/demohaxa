package com.example.demohexa.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demohexa.data.BookDto;
import com.example.demohexa.entity.Book;
import com.example.demohexa.mappers.BookMapper;
import com.example.demohexa.ports.spi.BookPersistencePort;
import com.example.demohexa.repository.BookRepository;

@Service
public class BookJpaAdapter implements BookPersistencePort {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDto addBook(BookDto bookDto) {

		Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);

		Book bookSaved = bookRepository.save(book);

		return BookMapper.INSTANCE.bookToBookDto(bookSaved);
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public BookDto updateBook(BookDto bookDto) {
		return addBook(bookDto);
	}

	@Override
	public List<BookDto> getBooks() {

		List<Book> bookList = bookRepository.findAll();

		return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
	}

	@Override
	public BookDto getBookById(Long bookId) {

		Optional<Book> book = bookRepository.findById(bookId);

		if (book.isPresent()) {
			return BookMapper.INSTANCE.bookToBookDto(book.get());
		}

		return null;
	}
}
