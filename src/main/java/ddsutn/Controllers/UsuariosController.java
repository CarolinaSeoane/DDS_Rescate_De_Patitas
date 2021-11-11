package ddsutn.Controllers;

import ddsutn.Seguridad.Sesion.LoginResponse;
import ddsutn.Seguridad.Sesion.SesionManager;
import ddsutn.Seguridad.Usuario.Administrador;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioRDTO;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioSigninDTO;
import ddsutn.Seguridad.Usuario.StandardUser;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Seguridad.Usuario.Voluntario;
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

        Usuario usr = usuarioSvc.signinUsuario(usuarioSigninDTO);

        SesionManager sesionManager = SesionManager.get();
        String rol = usr.getClass().getAnnotation(DiscriminatorValue.class).value();
//        System.out.println(rol);

        String idSesion = sesionManager.crear(usr);

        return new LoginResponse(idSesion, rol);
    }

}