package ddsutn.Servicios;

import ddsutn.Repositorio.UsuarioRepo;
import ddsutn.Seguridad.Usuario.Administrador;
import ddsutn.Seguridad.Usuario.StandardUser;
import ddsutn.Seguridad.Usuario.Usuario;
import ddsutn.Seguridad.Usuario.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSvc {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Autowired
    PasswordEncoder encoder;

    protected Usuario save(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public Usuario signupAdmin(Administrador body){
        body.setPassword(encoder.encode(body.getPassword()));

        return save(new Administrador(body));
    }

    public Usuario signupStandardUser(StandardUser body){
        body.setPassword(encoder.encode(body.getPassword()));

        return save(new StandardUser(body));
    }

    public Usuario signupVoluntario(Voluntario body){
        body.setPassword(encoder.encode(body.getPassword()));

        return save(new Voluntario(body));
    }
}
