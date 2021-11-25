package ddsutn.Controllers;

import ddsutn.Business.Persona.DTOs.RescatistaDTO;
import ddsutn.Servicios.RescatistaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rescatista")
@CrossOrigin
@Controller
public class RescatistaController {

    @Autowired
    private RescatistaSvc rescatistaSvc;

    @PostMapping("/registrar")
    public ResponseEntity<Object> crearRescatista(@RequestBody RescatistaDTO rescatistaDTO, @RequestHeader("Authorization") String id_qr) {
        try {
            //rescatistaSvc.save(rescatista);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

}
