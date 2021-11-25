package ddsutn.Business.Mascota;

import ddsutn.Business.Hogares.Ubicacion;
import ddsutn.Business.Mascota.Foto.Foto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.IOException;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("con_QR")

public class MascotaPerdidaConQr extends MascotaPerdida {

	@OneToOne
	@JoinColumn(name = "id_mascota")
	private Mascota mascotaAsociada;

	public MascotaPerdidaConQr(Set<Foto> fotos, String estado, Ubicacion ubicacion, TipoMascota tipo) {
		super(fotos, estado, ubicacion, tipo);
	}

    /*public Mascota reconocerMascota(String/Integer id) {
       todo: consulta la base de datos y busca el id segun el qr escaneado y asigna la mascota al atributo mascota.
       this.mascota = mascota de la base de datos
    }*/

    public void notificarMascota() {
        try {
            mascotaAsociada.meEncontraron();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
