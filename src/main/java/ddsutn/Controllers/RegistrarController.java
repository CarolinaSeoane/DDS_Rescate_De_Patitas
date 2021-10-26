package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.OrganizacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/registrar")
public class RegistrarController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    //respuestas vistas

    @GetMapping
    public String registrarMascota() {
        return "Registrar_Mascota";
    }

    @GetMapping("/datos-personales")
    public String datosPersonales() {
        return "Datos_Dueño_Y_Contactos";
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
