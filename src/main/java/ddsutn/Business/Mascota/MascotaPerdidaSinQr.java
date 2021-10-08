package ddsutn.Business.Mascota;

import ddsutn.Business.Hogares.Ubicacion;
import ddsutn.Business.Mascota.Foto.Foto;
import ddsutn.Business.Publicacion.PublicacionMascotaEncontrada;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("sin_QR")

public class MascotaPerdidaSinQr extends MascotaPerdida {

	@OneToOne(mappedBy = "mascota")
	private PublicacionMascotaEncontrada publicacion;

	public MascotaPerdidaSinQr(Set<Foto> fotos, String estado, Ubicacion ubicacion) {
		super(fotos, estado, ubicacion);
	}
/*
    public PublicacionMascotaEncontrada generarPublicacion(Rescatista rescatista){
        return new PublicacionMascotaEncontrada(rescatista,this);
    }
*/
}
