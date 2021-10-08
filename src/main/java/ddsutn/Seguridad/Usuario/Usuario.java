package ddsutn.Seguridad.Usuario;

import lombok.*;
//import sun.security.util.Password;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)

abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	protected String usuario;
	protected String password;

}
