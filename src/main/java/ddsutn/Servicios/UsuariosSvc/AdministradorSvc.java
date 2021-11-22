package ddsutn.Servicios.UsuariosSvc;

import ddsutn.Repositorio.UsuarioRepo;
import ddsutn.Seguridad.Usuario.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministradorSvc {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public Administrador save(Administrador administrador) {
        return usuarioRepo.save(administrador);
    }

    public Administrador findAdminByUsuario(String usuario) {
        return usuarioRepo.findAdminByUsuario(usuario).orElse(null);
    }

    public Administrador signupAdmin(Administrador body){
        body.setPassword(encoder.encode(body.getPassword()));

        if(findAdminByUsuario(body.getUsuario()) != null)
            throw new RuntimeException();

        return save(new Administrador(body));
    }

}

