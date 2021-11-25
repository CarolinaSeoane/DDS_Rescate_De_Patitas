package ddsutn.Business.Mascota;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	@JsonBackReference
	private PublicacionMascotaEncontrada publicacion;

	public MascotaPerdidaSinQr(Set<Foto> fotos, String estado, Ubicacion ubicacion, TipoMascota tipo) {
		super(fotos, estado, ubicacion, tipo);
	}
/*
    public PublicacionMascotaEncontrada generarPublicacion(Rescatista rescatista){
        return new PublicacionMascotaEncontrada(rescatista,this);
    }
*/
}
