package ddsutn.Controllers;

import ddsutn.Business.Mascota.MascotaPerdida;
import ddsutn.Business.Publicacion.PublicacionMascotaEncontrada;
import ddsutn.Servicios.MascotaPerdidaSvc;
import ddsutn.Servicios.MascotaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/mascota-perdida")
public class MascotaPerdidaController {

    @Autowired
    private MascotaPerdidaSvc mascotaPerdidaSvc;

    @Autowired
    private MascotaSvc mascotaSvc;

    @PostMapping("/crear")
    public ResponseEntity<Object> crearMascotaEncontradaConQR(@RequestBody PublicacionMascotaEncontrada body, @RequestHeader("Authorization") String id_qr) {

        MascotaPerdida mascotaPerdida = body.getMascota();
        mascotaPerdida.setMascotaAsociada(mascotaSvc.findById_QR(id_qr));

        try {
            mascotaPerdidaSvc.save(mascotaPerdida);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

    }
    
}
