package ddsutn.Controllers;

import ddsutn.Seguridad.Sesion.LoginResponse;
import ddsutn.Seguridad.Sesion.SesionManager;
import ddsutn.Seguridad.Usuario.Administrador;
import ddsutn.Seguridad.Usuario.DTOs.AdministradorDTO;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioRDTO;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioSigninDTO;
import ddsutn.Seguridad.Usuario.StandardUser;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Seguridad.Usuario.Voluntario;
import ddsutn.Servicios.AdministradorSvc;
import ddsutn.Servicios.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.DiscriminatorValue;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioSvc usuarioSvc;

    @Autowired
    AdministradorSvc administradorSvc;


    //Creacion de usuarios
    @PostMapping(value = "/registrar-admin")
    public ResponseEntity<UsuarioRDTO> signupAdmin(
            @RequestBody Administrador body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupAdmin(body).toRDTO());
    }

    @PostMapping(value = "/registrar-estandar")
    public ResponseEntity<UsuarioRDTO> signupStandardUser(
            @RequestBody StandardUser body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupStandardUser(body).toRDTO());
    }

    @PostMapping(value = "/registrar-voluntario")
    public ResponseEntity<UsuarioRDTO> signupVoluntario(
            @RequestBody Voluntario body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupVoluntario(body).toRDTO());
    }

    //Sign in

    @PostMapping(value = "/iniciar-sesion")
    public LoginResponse login(@RequestBody UsuarioSigninDTO usuarioSigninDTO, HttpServletResponse response) {

        Usuario usr = usuarioSvc.signinUsuario(usuarioSigninDTO);                       // se valida contraseña y nombre de usuario. no importa el rol

        SesionManager sesionManager = SesionManager.get();
        String rol = usr.getClass().getAnnotation(DiscriminatorValue.class).value();    // pregunto cual es el rol para mandarselo a Vue para que sepa si esta iniciando sesion un Admin, Voluntario o Standard (y saber que pantalla principal mostrarle)

        String idSesion = sesionManager.crear(usr);                                     // La idea en el Sesion Manager (por ahora) es vincular al idSesion con un usuario y contraseña (sin importar su rol)

        return new LoginResponse(idSesion, rol);                                        // Como respuesta devuelvo el idSesion para guardarlo en localStorage y el rol lo paso para que Vue sepa a que pantalla principal redirigir al usuario
    }

    @GetMapping(value = "/datos-administrador") // usando sesion
    public ResponseEntity<AdministradorDTO> obtenerMisDatos(@RequestHeader("Authorization") String idSesion) {

        SesionManager sesionManager = SesionManager.get();
        Usuario usr = (Usuario) sesionManager.obtenerAtributo(idSesion);                // Obtengo el usuario asociado a la sesion

        Administrador administrador = administradorSvc.findByUsuario(usr.getUsuario()); // Con el nombre de usuario obtengo todos los datos de ese usuario

        AdministradorDTO administradorDTO = administrador.toDTO();                      // Paso esos datos a un DTO

        return ResponseEntity.status(200).body(administradorDTO);                       // Retorno el DTO
    }

}


