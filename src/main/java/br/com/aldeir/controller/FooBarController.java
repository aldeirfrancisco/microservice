package br.com.aldeir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("book-service")
public class FooBarController {
	
		
	@GetMapping("/foo-bar")
	public String findBook() {
		
    return "Foo-Bar!!";
	
	}
   
	
}
