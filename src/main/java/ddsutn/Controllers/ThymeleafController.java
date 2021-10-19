
// Para esta entrega usamos los JSON

/*
package ddsutn.Controllers;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/adoptar")
public class AdoptarController {

    @Autowired
    PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;


    @GetMapping("/")
    public String adoptar() {
        return "Adoptar_Mascota";
    }

    @RequestMapping("/publicaciones")
    public String Mascotas_En_Adopción(Model model) {
        List<PublicacionDarEnAdopcion> publicaciones =publicacionDarEnAdopcionSvc.publicaciones();

        model.addAttribute("recientes",publicaciones.stream()
                .sorted(Comparator.comparingLong( PublicacionDarEnAdopcion::getId )
                        .reversed())
                .limit(4)
                .collect(Collectors.toList()));

        model.addAttribute("publicaciones",publicaciones.stream().limit(2).collect(Collectors.toList()));

        model.addAttribute("cantidad",4);
        model.addAttribute("ordenado","");
        return "Publicaciones_Adopcion";

    }

    @GetMapping("/publicaciones/{cantidad}")
    public String cargarMas(Model model, @PathVariable int cantidad) {
        List<PublicacionDarEnAdopcion> publicaciones =publicacionDarEnAdopcionSvc.publicaciones();

        model.addAttribute("recientes",publicaciones.stream()
                .sorted(Comparator.comparingLong( PublicacionDarEnAdopcion::getId )
                        .reversed())
                .limit(4)
                .collect(Collectors.toList()));

        model.addAttribute("publicaciones",publicaciones.stream().limit(cantidad).collect(Collectors.toList()));
        model.addAttribute("cantidad",cantidad+2);
        model.addAttribute("ordenado","");
        return "Publicaciones_Adopcion";
    }

    @GetMapping("/publicaciones/{cantidad}/{ordenado}")
    public String ordenar(Model model, @PathVariable int cantidad,@PathVariable String ordenado) {
        List<PublicacionDarEnAdopcion> publicaciones =publicacionDarEnAdopcionSvc.publicaciones();

        model.addAttribute("recientes",publicaciones.stream()
                .sorted(Comparator.comparingLong( PublicacionDarEnAdopcion::getId )
                        .reversed())
                .limit(4)
                .collect(Collectors.toList()));

        model.addAttribute("publicaciones",publicaciones.stream()
                .sorted(Comparator.comparing(n->n.getMascota().getNombre()) )
                .limit(cantidad)
                .collect(Collectors.toList()));
        model.addAttribute("cantidad",cantidad+2);
        model.addAttribute("ordenado","ordenado");
        return "Publicaciones_Adopcion";
    }

}*/