package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/adoptar")
public class AdoptarController {

    @Autowired
    private PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;
    //respuestas vistas
    @GetMapping
    public String adoptar() {
        return "Adoptar_Mascota";
    }

    @GetMapping("/publicaciones")
    public String publicaciones(){
        return "Publicaciones_Adopcion";
    }

    //respuestas api
    @ResponseBody
    @GetMapping("/api/publicaciones")
    public List<PublicacionDarEnAdopcion> findAll(){
        return publicacionDarEnAdopcionSvc.findAll();
    }

    @ResponseBody
    @GetMapping("/api/publicaciones/{id}")
    public Optional<PublicacionDarEnAdopcion> findById(@PathVariable Long id) {
        return publicacionDarEnAdopcionSvc.findById(id);
    }

}
