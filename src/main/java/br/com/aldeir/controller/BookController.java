package br.com.aldeir.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldeir.model.Book;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	//http://localhost:8100/book-service/1/BRL
	
	@GetMapping("/{id}/{currency}")
	private Book findBook( @PathVariable("id") Long id,
			               @PathVariable("currency") String currency) {
		 var port =	environment.getProperty("local.server.port");
		return 
				new Book(1L, "Aldeir", "docker deep dive",
						new Date(), Double.valueOf(13.07),currency, port);
	}
}
