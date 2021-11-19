package ddsutn.Controllers;

import ddsutn.Business.Mascota.DTOs.MascotaDTO;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Servicios.MascotaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mascota")
@CrossOrigin
public class MascotaController {

    @Autowired
    private MascotaSvc mascotaSvc;

    @PostMapping("/registrar")
    public ResponseEntity<Object> crearMascota(@RequestBody Mascota mascota) {
        // convertir foto
        try {
            mascotaSvc.save(mascota);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            //logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/obtener/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MascotaDTO> obtenerMascota(@PathVariable Long id) {
        try {
            Mascota mascota = mascotaSvc.findById(id);
            MascotaDTO mascotaDTO = mascota.toDTO();
            return ResponseEntity.status(200).body(mascotaDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(400).build();
        }
    }

}
