package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrarMascotaController {

	@RequestMapping("/Datos_Dueño_Y_Contactos")
	public String mostrarPantalla(){
		return "Datos_Dueño_Y_Contactos";
	}

}
