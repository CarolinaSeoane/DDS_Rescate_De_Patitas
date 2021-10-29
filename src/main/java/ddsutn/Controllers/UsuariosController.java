package ddsutn.Controllers;

import ddsutn.Seguridad.Usuario.Administrador;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioRDTO;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioSigninDTO;
import ddsutn.Seguridad.Usuario.StandardUser;
import ddsutn.Seguridad.Usuario.Voluntario;
import ddsutn.Servicios.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioSvc usuarioSvc;

    //Creacion de usuarios
    @PostMapping(value = "/signupAdmin")
    public ResponseEntity<UsuarioRDTO> signupAdmin(
            @RequestBody Administrador body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupAdmin(body).toRDTO());
    }

    @PostMapping(value = "/signupStandard")
    public ResponseEntity<UsuarioRDTO> signupStandardUser(
            @RequestBody StandardUser body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupStandardUser(body).toRDTO());
    }

    @PostMapping(value = "/signupVoluntario")
    public ResponseEntity<UsuarioRDTO> signupVoluntario(
            @RequestBody Voluntario body
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSvc.signupVoluntario(body).toRDTO());
    }

    //Sign in
    @PostMapping(value = "/signin")
    public ResponseEntity<UsuarioRDTO> attemptSignin(
            @RequestBody UsuarioSigninDTO body
    ){
        return ResponseEntity.ok(usuarioSvc.signinUsuario(body).toRDTO());
    }
}
