package ddsutn.Servicios.UsuariosSvc;

import ddsutn.Repositorio.UsuarioRepo;
import ddsutn.Seguridad.Usuario.StandardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class StandardSvc {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    // Lo vamos a usar para registrar al usuario cuando quiere registrar una mascota
    public StandardUser save(StandardUser standardUser) {
        return usuarioRepo.save(standardUser);
    }

    public StandardUser findStandardByUsuario(String usuario) {
        return usuarioRepo.findStandardByUsuario(usuario).orElse(null);
    }

    public StandardUser signupStandardUser(StandardUser body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findStandardByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new StandardUser(body));
    }

}
