package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Seguridad.Sesion.LoginResponse;
import ddsutn.Seguridad.Sesion.SesionManager;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioSigninDTO;
import ddsutn.Seguridad.Usuario.StandardUser;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Servicios.OrganizacionSvc;
import ddsutn.Servicios.PublicacionDarEnAdopcionSvc;
import ddsutn.Servicios.PublicacionMascotaEncontradaSvc;
import ddsutn.Servicios.UsuariosSvc.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.DiscriminatorValue;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private UsuarioSvc usuarioSvc;

    public Boolean validarSesion(String idSesion) {

        SesionManager sesionManager = SesionManager.get();
        Usuario usr = (Usuario) sesionManager.obtenerAtributo(idSesion);

        return (usr != null);

    }

    @RequestMapping("/")
    public String inicio(Model model) {
        return "Cliente_Liviano_index";
    }

    @RequestMapping("/inicio_sesion")
    public String inicioSesion(Model model) {
        return "Cliente_Liviano_Iniciar_Sesion";
    }

    @PostMapping(value = "/iniciar-sesion")
    public ResponseEntity<LoginResponse> login(@RequestBody UsuarioSigninDTO usuarioSigninDTO) {

        Usuario usr = usuarioSvc.signinUsuario(usuarioSigninDTO);                       // se valida contraseña y nombre de usuario. no importa el rol

        SesionManager sesionManager = SesionManager.get();
        String rol = usr.getClass().getAnnotation(DiscriminatorValue.class).value();    // pregunto cual es el rol para mandarselo a Vue para que sepa si esta iniciando sesion un Admin, Voluntario o Standard (y saber que pantalla principal mostrarle)

        String idSesion = sesionManager.crear(usr);                                     // La idea en el Sesion Manager (por ahora) es vincular al idSesion con un usuario y contraseña (sin importar su rol)

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(idSesion, rol));

        //return new LoginResponse(idSesion, rol);                                         Como respuesta devuelvo el idSesion para guardarlo en localStorage y el rol lo paso para que Vue sepa a que pantalla principal redirigir al usuario
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


    @RequestMapping("/adoptar/publicacion/{id}")
    public String publicacionAdopcion(Model model, @PathVariable Long id,@RequestParam String sesion) {

        model.addAttribute("publicacion",  publicacionDarEnAdopcionSvc.findById(id).get());

        if(validarSesion(sesion)){
            model.addAttribute("sesion","login");
        }else{
            model.addAttribute("sesion","logout");
        }


        model.addAttribute("estado","pendiente");
        return "Cliente_Liviano_Publicacion_Adopcion";
    }


    @RequestMapping("/adoptar/publicacion/{id}/adoptar")
    public String publicacionAdopcionAdoptar(Model model, @PathVariable Long id,@RequestParam String sesion) {

        if(validarSesion(sesion)){
            model.addAttribute("sesion","login");
        }else{
            model.addAttribute("sesion","logout");
        }
        SesionManager sesionManager = SesionManager.get();
        StandardUser usr = (StandardUser) sesionManager.obtenerAtributo(sesion);
        Optional<PublicacionDarEnAdopcion> publicacion = publicacionDarEnAdopcionSvc.findById(id);

        String estado ;

        if( publicacion.isPresent() && usr!=null ){
            publicacion.get().notificarDuenioSobreInteresado(usr.getDuenioAsociado().getEmail());
            estado = "ok";

        }else{
            estado="error";
        }
        model.addAttribute("estado",estado);
        model.addAttribute("publicacion",  publicacionDarEnAdopcionSvc.findById(id).get());
        return "Cliente_Liviano_Publicacion_Adopcion";
    }

}
