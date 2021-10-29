package ddsutn.Controllers;

import ddsutn.Business.Mascota.Caracteristica.Caracteristica;
import ddsutn.Servicios.CaracteristicaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/caracteristicas")
public class CaracteristicasController {

	@Autowired
	private CaracteristicaSvc caracteristicaSvc;

	@ResponseBody
	@GetMapping
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicaSvc.findAll();
	}

}
