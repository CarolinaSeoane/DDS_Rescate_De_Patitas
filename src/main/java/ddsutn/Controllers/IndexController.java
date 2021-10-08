package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String mostrarPantalla(Model model) {
		model.addAttribute("mensaje", "Estas en la página principal.");
		return "index";
	}

}
