package ddsutn.Business.Mascota.Foto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Business.Mascota.MascotaPerdida;
import ddsutn.Business.Organizacion.Organizacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "foto")

public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "path")
	private String path;

	@ManyToOne()
	@JoinColumn(name = "id_mascota_perdida")
	@JsonBackReference(value = "fotosPerdida")
	private MascotaPerdida mascotaPerdida;

	@ManyToOne()
	@JoinColumn(name = "id_mascota")
	@JsonBackReference(value = "fotos")
	private Mascota mascota;


	public void convertirFoto(Organizacion organizacion) {
		Resolucion resolucion = organizacion.getResolucion();
		String calidad = organizacion.getCalidad();
		this.adaptarFoto(path, resolucion.getPixelesAlto(), resolucion.getPixelesAncho(), calidad);
	}

	// La imagen se guarda en el mismo directorio donde está la imagen original, pero con la nueva extension
	private void adaptarFoto(String path, int pixelesAlto, int pixelesAncho, String calidad) {
		File origen = new File(path);
		File destino = new File(origen.getPath().replaceAll("\\..*", "." + calidad));
		try{
			Thumbnails.of(origen).size(pixelesAlto, pixelesAncho).outputFormat(calidad).toFile(destino);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
