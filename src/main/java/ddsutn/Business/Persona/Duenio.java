package ddsutn.Business.Persona;

import ddsutn.Business.Mascota.Mascota;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("Duenio")

public class Duenio extends Persona {

	@OneToMany(mappedBy = "duenio", cascade = {CascadeType.ALL})
	private Set<Mascota> mascotas;


	public Duenio(TipoDcto tipoDocumento, int nroDocumento, Date fechaDeNacimiento, Contacto contacto, List<Contacto> otrosContactos, String domicilio) {
		super(tipoDocumento, nroDocumento, fechaDeNacimiento, contacto, otrosContactos, domicilio);
		this.mascotas = new HashSet<>();
	}

    public void mascotaEncontrada() {
        this.notificarAMisContactos("Su mascota fue encontrada");
    }

    public void agregarMascota(Mascota unaMascota) {
        if(!this.mascotas.contains(unaMascota)) {
            mascotas.add(unaMascota);
        }
    }

    public void eliminarMascota(Mascota unaMascota) {
        if(mascotas.contains(unaMascota)) {
            this.mascotas.remove(unaMascota);
        }
    }

}
