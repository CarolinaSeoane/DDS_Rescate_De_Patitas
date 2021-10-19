package ddsutn.Seguridad.Usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ddsutn.Business.Mascota.Caracteristica.Caracteristica;
import ddsutn.Business.Organizacion.Organizacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("Administrador")

public class Administrador extends Usuario {

	@ManyToOne
	@JoinColumn(name = "id_organizacion")
    @JsonBackReference
    private Organizacion organizacion;

	public Administrador(String usuario, String password, Organizacion organizacion){
		this.setId(null);
		this.usuario = usuario;
		this.password = password;
		this.organizacion = organizacion;
	}

    public void agregarCaracteristica(Caracteristica caracteristica) {
		organizacion.agregarCaracteristica(caracteristica);
	}

    public void habilitarCaracteristica(Caracteristica caracteristica){
        organizacion.agregarCaracteristica(caracteristica);
    }

    public void deshabilitarCaracteristica(Caracteristica caracteristica){
        organizacion.eliminarCaracteristica(caracteristica);
    }

    public void crearAdministrador(String usuario, String contraseña) {
        Administrador nuevoAdmin = new Administrador(usuario, contraseña, this.organizacion);
        organizacion.agregarAdministrador(nuevoAdmin);
    }

}
