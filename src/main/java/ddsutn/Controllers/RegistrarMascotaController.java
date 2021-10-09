package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrarMascotaController {

	@RequestMapping("/Registrar_Mascota")
	public String mostrarPantalla(){
		return "Registrar_Mascota";
	}

}
