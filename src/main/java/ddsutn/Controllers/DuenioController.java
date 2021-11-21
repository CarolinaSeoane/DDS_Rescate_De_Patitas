package ddsutn.Controllers;

import ddsutn.Business.Persona.Duenio;
import ddsutn.Servicios.DuenioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/dueño")
@CrossOrigin
public class DuenioController {

    @Autowired
    private DuenioSvc duenioSvc;

    @PostMapping("/registrar")
    public ResponseEntity<Object> crearDuenio(@RequestBody Duenio duenio) {
        duenio.getMascotas().forEach(mascota -> {
            mascota.setId_QR(UUID.randomUUID().toString());
        });
        /* QR? */
        try {
            duenioSvc.save(duenio);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

}
