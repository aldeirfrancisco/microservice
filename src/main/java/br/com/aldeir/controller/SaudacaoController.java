package br.com.aldeir.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldeir.model.Saudacao;

@RestController
public class SaudacaoController {
  
	 private static final String template = "hello1, %s!";
	 private static final AtomicLong  counter = new AtomicLong();
	 
	
	 @RequestMapping("/saudacao")
	 public Saudacao greeting(@RequestParam(value = "nome", defaultValue = "World") String nome) {
		   
		   return new Saudacao(counter.incrementAndGet(),
             String.format(template,nome));
	 }
}
