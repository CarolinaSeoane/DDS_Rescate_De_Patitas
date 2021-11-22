package ddsutn.Controllers;

import ddsutn.Business.Mascota.Foto.Resolucion;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Business.Publicacion.DTOs.PubDarEnAdopcionDTO;
import ddsutn.Business.Publicacion.Pregunta.PreguntaPublicacion;
import ddsutn.Business.Publicacion.DTOs.PreguntaPublicacionDTO;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.MascotaSvc;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dar-en-adopcion")
@CrossOrigin
public class PublicacionDarEnAdopcionController {

	@Autowired
	private PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;

	@Autowired
	private MascotaSvc mascotaSvc;

	@PostMapping(value = "/guardar")
	public ResponseEntity guardarPublicacion(@RequestBody PubDarEnAdopcionDTO publicacion) {

		try {
			Mascota mascota = mascotaSvc.findById(publicacion.getMascota().getId());
			PublicacionDarEnAdopcion pub = publicacion.toPublicacionDarEnAdopcion(mascota);
			publicacionDarEnAdopcionSvc.save(pub);
			return ResponseEntity.status(200).build();
		} catch (Exception ex) {
			return ResponseEntity.status(400).build();
		}
	}
}
