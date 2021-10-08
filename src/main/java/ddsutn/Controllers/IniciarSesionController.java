package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IniciarSesionController {

	@RequestMapping("/Iniciar_Sesion")
	public String mostrarPantalla(){
		return "Iniciar_Sesion";
	}
}
