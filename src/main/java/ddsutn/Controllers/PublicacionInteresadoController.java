package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionInteresado;
import ddsutn.Servicios.PublicacionInteresadoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/publicacion-interesado")
@CrossOrigin
public class PublicacionInteresadoController {

	@Autowired
	private PublicacionInteresadoSvc publicacionInteresadoSvc;

	@PostMapping("/crear")
	public ResponseEntity<Object> guardar_publicacion(@RequestBody PublicacionInteresado publicacionInteresado) {
		try {
			publicacionInteresadoSvc.save(publicacionInteresado);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
