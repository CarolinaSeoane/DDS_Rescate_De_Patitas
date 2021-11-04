package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionMascotaEncontrada;
import ddsutn.Servicios.PublicacionMascotaEncontradaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/perdidas")
public class PerdidasController {

    @Autowired
    private PublicacionMascotaEncontradaSvc publicacionMascotaEncontradaSvc;

    @ResponseBody
    @GetMapping
    public List<PublicacionMascotaEncontrada> findAll(){
        return publicacionMascotaEncontradaSvc.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Optional<PublicacionMascotaEncontrada> findById(@PathVariable Long id) {
        return publicacionMascotaEncontradaSvc.findById(id);
    }

}
