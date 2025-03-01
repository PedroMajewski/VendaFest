package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Evento;
import app.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	public EventoRepository eventoRepository;
	
	public String save(Evento evento) {
		this.eventoRepository.save(evento);
		return "Curso salvo com sucesso!";
	}
	
	
	public String update(long id ,Evento evento) {
		evento.setId(id);
		this.eventoRepository.save(evento);
		return "Evento com o ID: " + id + " editado com sucesso!";
	}
	
	public String delete(long id) {
		this.eventoRepository.deleteById(id);
		return "Evento deletado com sucesso!";
	}
	 
	public Evento findById(long id) {
		return this.eventoRepository.findById(id).get();
	}
	
	public List<Evento> findAll() {
		return this.eventoRepository.findAll();
	}
	
}
