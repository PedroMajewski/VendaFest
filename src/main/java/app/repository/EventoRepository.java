package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	
}
