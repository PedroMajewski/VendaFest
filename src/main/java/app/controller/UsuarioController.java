package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Usuario;
import app.service.UsuarioService;


@RestController
@RequestMapping("/vendafest/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioService usuarioService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Usuario usuario) {
		try {
			String mensagem = this.usuarioService.save(usuario);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id,@RequestBody Usuario usuario) {
		try {
			String mensagem = this.usuarioService.update(id, usuario);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			String mensagem = this.usuarioService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		try {
			Usuario usuario = this.usuarioService.findById(id);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Usuario>> findAll(){
		try {
			List<Usuario> UsuarioAll = this.usuarioService.findAll();
			return new ResponseEntity<>(UsuarioAll, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}