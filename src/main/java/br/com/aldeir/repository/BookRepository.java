package br.com.aldeir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aldeir.model.Book;

public interface BookRepository  extends JpaRepository<Book, Long> {
	
}
