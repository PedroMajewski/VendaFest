package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Usuario;
import app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// salva usuário criado
	public String save(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return "Salvo com Sucesso!";
	}
	
	// encontra por id
	public Usuario findById(long id) {
		return this.usuarioRepository.findById(id).get();
	}
	
	// encontra todos
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}
	
	// atualiza cadastro
	public String update(long id ,Usuario usuario) {
		usuario.setId(id);
		this.usuarioRepository.save(usuario);
		return "Usuario com o ID: " + id + " editado com sucesso!";
	}
	
	// deleta cadastro
	public String delete(long id) {
		this.usuarioRepository.deleteById(id);
		return "Usuario deletado com sucesso!";
	}
}
