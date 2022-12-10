package br.com.aldeir.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@Tag(name = "Foo-Bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
		
	@GetMapping("/foo-bar")
	@Operation(summary = "Foo-bar")
	@Bulkhead(name = "default")
	public String findBook() {
		logger.info("request to foo bar received!");
		var response =	new RestTemplate().getForEntity("http://localhost:8100/foo-bar" , String.class);
	    return response.getBody();
	
	}
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!";
	}
	
}
