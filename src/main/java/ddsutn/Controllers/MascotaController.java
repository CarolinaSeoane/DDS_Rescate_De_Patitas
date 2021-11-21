package ddsutn.Controllers;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import ddsutn.Business.Mascota.DTOs.MascotaDTO;
import ddsutn.Business.Mascota.Foto.Foto;
import ddsutn.Business.Mascota.Foto.QR;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Business.Persona.Duenio;
import ddsutn.Seguridad.Sesion.SesionManager;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Servicios.MascotaSvc;
import ddsutn.Servicios.UsuariosSvc.StandardSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/mascota")
@CrossOrigin
public class MascotaController {

    @Autowired
    private MascotaSvc mascotaSvc;

    @Autowired
    private StandardSvc standardSvc;

    private QR QR = new QR();

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

    @PostMapping("/agregar-mascota")
    public void agregarMascota(@RequestBody List<Mascota> mascotas, @RequestHeader("Authorization") String idSesion) {

        SesionManager sesionManager = SesionManager.get();
        Usuario usr = (Usuario) sesionManager.obtenerAtributo(idSesion);
        Duenio duenio = standardSvc.findStandardByUsuario(usr.getUsuario()).getDuenioAsociado();

        mascotas.forEach(mascota -> {
            mascota.setId_QR(UUID.randomUUID().toString());
            mascota.setDuenio(duenio);
        });

        mascotaSvc.saveAll(mascotas);

    }

    @ResponseBody
    @GetMapping(value="/obtener-QR")
    public ResponseEntity<Foto> obtenerQRMascota() throws NotFoundException, IOException, WriterException {
        String qr_bs64 = QR.generarQR("dffds");
        Foto foto = new Foto();
        foto.setContenidoBase64(qr_bs64);
        try {
            return ResponseEntity.status(200).body(foto);
        } catch (Exception ex) {
            return ResponseEntity.status(400).build();
        }
    }
}
