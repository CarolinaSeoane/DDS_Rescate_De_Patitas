package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/adoptar")
@CrossOrigin
public class AdoptarController {

    @Autowired
    private PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;

    @ResponseBody
    @GetMapping("/publicaciones")
    public List<PublicacionDarEnAdopcion> findAll(){
        return publicacionDarEnAdopcionSvc.findAll();
    }

    @ResponseBody
    @GetMapping("/publicaciones/{id}")
    public Optional<PublicacionDarEnAdopcion> findById(@PathVariable Long id) {
        return publicacionDarEnAdopcionSvc.findById(id);
    }

}
