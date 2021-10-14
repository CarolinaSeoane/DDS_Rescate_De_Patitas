package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	@RequestMapping("/Iniciar Sesion")
	public String iniciarSesion() {
		return "Iniciar_Sesion";
	}



	@Autowired
	PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;

	@RequestMapping("/Adoptar/Publicaciones_Adopcion")
	public String Mascotas_En_Adopción(Model model) {

		List<PublicacionDarEnAdopcion> publicaciones =publicacionDarEnAdopcionSvc.publicaciones();

		model.addAttribute("recientes",publicaciones.stream()
				.sorted(Comparator.comparingLong( PublicacionDarEnAdopcion::getId )
						.reversed())
				.limit(4)
				.collect(Collectors.toList()));
		model.addAttribute("publicaciones",publicaciones);

		return "Publicaciones_Adopcion";

	}

	@RequestMapping("/Registrar Mascota")
	public String registrarMascota() {
		return "Registrar_Mascota";
	}

	@RequestMapping("/Adoptar")
	public String adoptar() {
		return "Adoptar_Mascota";
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

	@RequestMapping("/Buscar Mascota Perdida")
	public String buscarMascota() {
		return "Buscar_Mascota_Perdida";
	}



}
