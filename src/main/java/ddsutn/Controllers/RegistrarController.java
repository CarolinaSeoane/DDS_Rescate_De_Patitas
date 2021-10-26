package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/registrar")
public class RegistrarController {

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

}
