package br.com.aldeir.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aldeir.response.Cambio;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
  
	@RequestMapping(value = "/cambio-service/{amount}/{from}/{to}" )
	public Cambio getCambio(
			@PathVariable("amount") Double amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to);
		
}
