package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Evento;
import app.service.EventoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vendafest/evento")
public class EventoController {
	
	@Autowired
	public EventoService eventoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Evento evento) {
		try {
			String mensagem = this.eventoService.save(evento);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id,@RequestBody Evento evento) {
		try {
			String mensagem = this.eventoService.update(id, evento);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			String mensagem = this.eventoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Evento> findById(@PathVariable Long id){
		try {
			Evento evento = this.eventoService.findById(id);
			return new ResponseEntity<>(evento, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Evento>> findAll(){
		try {
			List<Evento> EventoAll = this.eventoService.findAll();
			return new ResponseEntity<>(EventoAll, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	
}
