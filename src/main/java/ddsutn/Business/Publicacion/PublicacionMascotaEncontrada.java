package ddsutn.Business.Publicacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ddsutn.Business.Mascota.MascotaPerdida;
import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Persona.Contacto;
import ddsutn.Business.Persona.Duenio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "publicacion_mascota_encontrada")
public class PublicacionMascotaEncontrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	@JsonBackReference(value = "encontradas")
	private Organizacion organizacion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_mascota")
	private MascotaPerdida mascota;

	@Column(name = "aceptada")
	private Boolean aceptada;


 /*   public PublicacionMascotaEncontrada(Rescatista rescatista , MascotaPerdidaSinQr mascota) {
        Sistema sistema = Sistema.getInstance();
        this.organizacion = sistema.getOrganizaciones().stream().min((organizacionA, organizacionB) ->
        {
            double numero = organizacionA.getUbicacion().calcularDistancia(mascota.getUbicacion()) -
                organizacionB.getUbicacion().calcularDistancia(mascota.getUbicacion());

            if (numero<0){
                return 1;
            }else if(numero == 0){
                return 0;
            }
            return -1;
        }).orElse(null);        //hacerlo mas bonito en algún futuro

        this.aceptadaPorVoluntario = false;
        this.rescatista = rescatista;
        this.mascota = mascota;
        sistema.getPublicaciones().agregarPublMascotaEncontrada(this);
    }*/

    public void aceptarPublicacionMascotaEncontrada() {
        this.aceptada = true;
    }


    public void notificarDuenioAparecido(Contacto duenioAparecido) {
        String mensaje = String.format("Ha aparecido el duenio de la mascota que ha rescatado!\nComunicarse con %s %s: Tel. %s - Email %s",
                duenioAparecido.getNombre(),
                duenioAparecido.getApellido(),
                duenioAparecido.getTelefono(),
                duenioAparecido.getEmail());
        this.getMascota().getRescatista().notificarAMisContactos(mensaje);
    }

	public void notificarDuenioAparecido(Duenio duenioAparecido) {
		String mensaje = String.format("Ha aparecido el duenio de la mascota que ha rescatado!\nComunicarse con %s %s: Tel. %s - Email %s",
				duenioAparecido.getNombre(),
				duenioAparecido.getApellido(),
				duenioAparecido.getTelefono(),
				duenioAparecido.getEmail());
		this.getMascota().getRescatista().notificarAMisContactos(mensaje);
	}

}
