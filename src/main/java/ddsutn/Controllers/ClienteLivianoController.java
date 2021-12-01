package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Seguridad.Sesion.SesionManager;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Servicios.OrganizacionSvc;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import ddsutn.Servicios.PublicacionMascotaEncontradaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/cliente-liviano")
public class ClienteLivianoController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    @Autowired
    private PublicacionDarEnAdopcionSvc publicacionDarEnAdopcionSvc;

    @Autowired
    private PublicacionMascotaEncontradaSvc publicacionMascotaEncontradaSvc;

    public Boolean validarSesion(String idSesion) {

        SesionManager sesionManager = SesionManager.get();
        Usuario usr = (Usuario) sesionManager.obtenerAtributo(idSesion);

        return (usr != null);

    }

    @RequestMapping("/organizaciones")
    public String organizaciones(Model model) {
        List<Organizacion> organizacionList = organizacionSvc.findAll();
        model.addAttribute("organizaciones", organizacionList);
        return "Cliente_Liviano_Organizaciones";
    }

    @RequestMapping("/publicaciones")
    public String Mascotas_En_Adopción(Model model) {
        List<PublicacionDarEnAdopcion> publicaciones = publicacionDarEnAdopcionSvc.findAll();
        model.addAttribute("recientes",publicaciones.stream()
                .sorted(Comparator.comparingLong( PublicacionDarEnAdopcion::getId )
                        .reversed())
                .limit(4)
                .collect(Collectors.toList()));
        model.addAttribute("publicaciones",publicaciones.stream().limit(4).collect(Collectors.toList()));
        model.addAttribute("cantidad",4);
        model.addAttribute("ordenado","");
        return "Cliente_Liviano_Publicaciones_Adopcion";
    }



    @RequestMapping("/perdidas/publicacion/{id}")
    public String publicacionMascotaPerdida(Model model, @PathVariable Long id, @RequestParam String sesion) {



        if(validarSesion(sesion)){
            model.addAttribute("sesion","login");
        }else{
            model.addAttribute("sesion","logout");
        }


        model.addAttribute("estado","pendiente");
        model.addAttribute("publicacion",  publicacionMascotaEncontradaSvc.findById(id).get());
        return "Cliente_Liviano_Publicacion_Mascota_Perdida";

    }
}
