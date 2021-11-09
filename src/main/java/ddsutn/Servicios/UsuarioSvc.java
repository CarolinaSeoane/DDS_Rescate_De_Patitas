package ddsutn.Servicios;

import ddsutn.Repositorio.UsuarioRepo;
import ddsutn.Seguridad.Usuario.Administrador;
import ddsutn.Seguridad.Usuario.DTOs.UsuarioSigninDTO;
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

    //Spring security
    @Autowired
    PasswordEncoder encoder;

    //Guardar usuario en bd
    protected Usuario save(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    //Creacion de usuarios
    public Usuario signupAdmin(Administrador body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new Administrador(body));
    }

    public Usuario signupStandardUser(StandardUser body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new StandardUser(body));
    }

    public Usuario signupVoluntario(Voluntario body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new Voluntario(body));
    }

    //Singin
    public Usuario signinUsuario(UsuarioSigninDTO body){
        Usuario usuario = findByUsuario(body.getUsuario());

        if(usuario != null) {
            if (!encoder.matches(body.getPassword(), usuario.getPassword())) {
                throw new RuntimeException();
            }
        } else throw new RuntimeException();

        return usuario;
    }

    public Usuario findByUsuario(String usuario){
        return usuarioRepo.findByUsuario(usuario).orElse(null);
    }

}
