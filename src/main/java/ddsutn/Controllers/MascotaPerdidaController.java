package ddsutn.Controllers;

import ddsutn.Business.Mascota.MascotaPerdidaSinQr;
import ddsutn.Servicios.MascotaPerdidaSinQrSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mascota-perdida")
@CrossOrigin
public class MascotaPerdidaController {

    @Autowired
    private MascotaPerdidaSinQrSvc mascotaPerdidaSinQrSvc;

    @PostMapping("/registrar")
    public ResponseEntity<Object> crearDuenio(@RequestBody MascotaPerdidaSinQr mascotaPerdidaSinQr ) {
        try {
            mascotaPerdidaSinQrSvc.save(mascotaPerdidaSinQr);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            //logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

}