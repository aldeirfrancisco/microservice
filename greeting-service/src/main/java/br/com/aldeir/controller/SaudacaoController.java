package br.com.aldeir.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldeir.config.GreetingConfig;
import br.com.aldeir.model.Saudacao;

@RestController
public class SaudacaoController {
    
	@Autowired
	private GreetingConfig greetingConfig;

	private static final String template = "%s, %s!";
	 private static final AtomicLong  counter = new AtomicLong();
	 
	
	 @RequestMapping("/saudacao")
	 public Saudacao greeting(@RequestParam(value = "nome", defaultValue = "") String nome) {
		   if(nome.isEmpty()) nome = greetingConfig.getDefaultValue();
		   
		   return new Saudacao(counter.incrementAndGet(),
             String.format(template,greetingConfig.getGreeting(),nome));
	 }
}
