package app.entity;

<<<<<<< HEAD
import jakarta.persistence.Id;
=======
>>>>>>> 9b77d08175607b464190728e756dedf2125ff92c
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	
	// CLASSE DE ENTIDADE DO USUÁRIO, AMBOS O NOME E A SENHA SÃO OBRIGARÓRIOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo NOME não pode ser vazio!")
	@Size(max = 75)
	private String nome;
	
	@NotBlank(message = "O campo SENHA não pode ser vazio!")
	@Size(min = 8, max = 16)
	private String senha;
	
	// VALOR BOOLEANO QUE IDENTIFICA SE O USUÁRIO É ADMINISTRADOR (CAPAZ)
	// CASO FOR, VAI PODER TIRAR PRODUTOS DO AR PARA QUE O VENDEDOR NÃO CONSIGA
	// UTILIZAR.
	private Boolean isAdmin;
}
