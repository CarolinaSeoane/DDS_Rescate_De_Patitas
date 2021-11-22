package ddsutn.Seguridad.Usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value = "voluntario")
	private Organizacion organizacion;


    public Voluntario(Voluntario body) {
        this.usuario = body.getUsuario();
        this.password = body.getPassword();
        this.organizacion = body.getOrganizacion();
    }

    public void validarPublicacion(PublicacionMascotaEncontrada publicacion){
        publicacion.aceptarPublicacionMascotaEncontrada(); // cambiarlo por id
    }

}
