package com.example.demohexa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demohexa.adapters.BookJpaAdapter;
import com.example.demohexa.ports.api.BookServicePort;
import com.example.demohexa.ports.spi.BookPersistencePort;
import com.example.demohexa.service.BookServiceImpl;

@Configuration
public class BookConfig {

	@Bean
	public BookPersistencePort bookPersistence() {
		return new BookJpaAdapter();
	}

	@Bean
	public BookServicePort bookService() {
		return new BookServiceImpl(bookPersistence());
	}
}