package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionMascotaEncontrada;
import ddsutn.Servicios.PublicacionMascotaEncontradaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/perdidas")
public class PerdidasController {

    @Autowired
    private PublicacionMascotaEncontradaSvc publicacionMascotaEncontradaSvc;

    @ResponseBody
    @GetMapping("/publicaciones")
    public List<PublicacionMascotaEncontrada> findAll(){
        return publicacionMascotaEncontradaSvc.findAll();
    }

    @ResponseBody
    @GetMapping("/publicaciones/{id}")
    public Optional<PublicacionMascotaEncontrada> findById(@PathVariable Long id) {
        return publicacionMascotaEncontradaSvc.findById(id);
    }

}
