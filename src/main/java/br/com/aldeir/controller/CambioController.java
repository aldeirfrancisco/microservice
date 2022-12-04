package br.com.aldeir.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldeir.model.Cambio;
import br.com.aldeir.repository.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	@Autowired
   private Environment environment; // obtenha o valor da propriedade que esteja no properties 
   
	@Autowired
	private CambioRepository cambioRepository;
	
	//http://localhost:8000/cambio-service/5/USD/BRL
	@RequestMapping(value = "/{amount}/{from}/{to}" )
	public Cambio getCambio(
			@PathVariable("amount") BigDecimal amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
	     var port =	environment.getProperty("local.server.port");//acessa varias informações da aplicação
	     var cambio = cambioRepository.findByFromAndTo(from, to);
	     
	     if(cambio == null) throw new RuntimeException("currency Unsupported");
	     
	     BigDecimal conversionFactor = cambio.getConversionFactor();
	     BigDecimal convertedValue = conversionFactor.multiply(amount);
	     cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
	     cambio.setEnvironment(port);

		return cambio;
	}
}
