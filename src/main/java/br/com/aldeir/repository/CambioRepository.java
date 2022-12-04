package br.com.aldeir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aldeir.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
  
	Cambio findByFromAndTo(String from, String to);
}
