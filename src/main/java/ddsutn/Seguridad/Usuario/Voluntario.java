package ddsutn.Seguridad.Usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ddsutn.Business.Organizacion.Organizacion;

import ddsutn.Business.Publicacion.PublicacionMascotaEncontrada;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("Voluntario")

public class Voluntario extends Usuario {

	@ManyToOne
	@JoinColumn(name = "id_organizacion")
    @JsonBackReference
	private Organizacion organizacion;

    public void validarPublicacion(PublicacionMascotaEncontrada publicacion){
        publicacion.aceptarPublicacionMascotaEncontrada(); // cambiarlo por id
    }

}
