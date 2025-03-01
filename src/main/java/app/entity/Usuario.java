package app.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	// CLASSE DE ENTIDADE DO USUÁRIO, AMBOS O NOME E A SENHA SÃO OBRIGARÓRIOS,
	// RELACIONAMENTOS: 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo NOME não pode ser vazio!")
	private String nome;
	
	@NotBlank(message = "O campo SENHA não pode ser vazio!")
	private String senha;
	
	// VALOR BOOLEANO QUE IDENTIFICA SE O USUÁRIO É ADMINISTRADOR (CAPAZ)
	// CASO FOR, VAI PODER TIRAR PRODUTOS DO AR PARA QUE O VENDEDOR NÃO CONSIGA
	// UTILIZAR.
	private Boolean isAdmin;
}
