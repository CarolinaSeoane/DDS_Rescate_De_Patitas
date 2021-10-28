package ddsutn.Business.Persona;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ddsutn.Business.Mascota.Mascota;

import ddsutn.Business.Mascota.MascotaPerdida;
import ddsutn.Business.Notificacion.Notificar;
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
    @JsonManagedReference(value = "mascotas")
	private Set<Mascota> mascotas;


    public Duenio(TipoDcto tipoDocumento, int nroDocumento, Date fechaDeNacimiento, List<Contacto> otrosContactos, String domicilio, String nombre, String apellido, String telefono, String email, List<Notificar> formasDeNotificacion, MascotaPerdida mascotaPerdida) {
        super(tipoDocumento, nroDocumento, fechaDeNacimiento, otrosContactos, domicilio,nombre, apellido, telefono, email, formasDeNotificacion);
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
