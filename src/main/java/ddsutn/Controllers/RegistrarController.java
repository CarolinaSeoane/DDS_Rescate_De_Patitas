package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Persona.Duenio;
import ddsutn.Business.Persona.Persona;
import ddsutn.Servicios.DuenioSvc;
import ddsutn.Servicios.OrganizacionSvc;
import ddsutn.Servicios.PersonaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/registrar")
@CrossOrigin
public class RegistrarController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    @Autowired
    private DuenioSvc duenioSvc;

    //respuestas vistas

    @GetMapping
    public String registrarMascota() {
        return "Registrar_Mascota";
    }

    @GetMapping("/datos-personales")
    public String datosPersonales() {
        return "Datos_Dueño_Y_Contactos";
    }


    @PostMapping("/datos-personales")
    public ResponseEntity<Object> crearDuenio(@RequestBody Duenio duenio) {
        try {
            duenioSvc.save(duenio);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch(Exception ex) {
            //logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/organizaciones")
    public String organizaciones() {
        return "Organizaciones";
    }


    //respuestas api
    @ResponseBody
    @GetMapping("/api/organizaciones")
    public List<Organizacion> findAll(){
        return organizacionSvc.findAll();
    }

}
