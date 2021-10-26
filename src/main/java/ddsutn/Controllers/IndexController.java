package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String localhost(Model model) {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("mensaje", "Estas en la página principal.");
		return "index";
	}

	@RequestMapping("/iniciar-sesion")
	public String iniciarSesion() {
		return "Iniciar_Sesion";
	}

	@RequestMapping("/Dar en Adopcion")
	public String darEnAdopcion() {
		return "Dar_En_Adopcion";
	}

	@RequestMapping("/Buscar Hogar")
	public String buscarHogar() {
		return "Buscar_Hogar";
	}

	@RequestMapping("/Encontre Mascota Perdida")
	public String encontreMascotaPerdida() {
		return "Encontre_Mascota_Perdida";
	}

}
