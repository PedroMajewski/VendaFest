package app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Cliente")
@Getter
@Setter

public class Cliente {
	
	@Id
	@NotNull
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotBlank (message = "O campo nome não pode estar vazio!")
	@Size (max = 50)
	@Column (nullable = false, length = 75)
	private String nome;
	
	@NotBlank (message = "O campo email não pode estar vazio!")
	@Size (max = 100, message = "O email deve ter no máximo 100 caracteres")
	@Column (nullable = false, unique = true, length = 100)
	private String email;
	
	@NotBlank (message = "O campo senha não pode estar vazio!")
	@Size (min = 8,max = 16, message = "A senha precisa ter pelo menos 8 caracteres")
	@Column (nullable = false, length = 16)
	private String senha;
	
	@NotBlank (message = "O campo telefone não pode estar vazio!")
	@Size (max = 16)
	@Column(nullable = false, length = 16)
	private String telefone;
	
	
}
