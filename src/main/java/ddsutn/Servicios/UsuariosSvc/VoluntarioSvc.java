package ddsutn.Servicios.UsuariosSvc;

import ddsutn.Repositorio.UsuarioRepo;

import ddsutn.Seguridad.Usuario.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioSvc {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public Voluntario save(Voluntario voluntario) {
        return usuarioRepo.save(voluntario);
    }

    public Voluntario findVoluntarioByUsuario(String usuario) {
        return usuarioRepo.findVoluntarioByUsuario(usuario).orElse(null);
    }

    public Voluntario signupVoluntario(Voluntario body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findVoluntarioByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new Voluntario(body));
    }

}
