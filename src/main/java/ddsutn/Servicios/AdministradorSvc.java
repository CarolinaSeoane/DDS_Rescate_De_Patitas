package ddsutn.Servicios;

import ddsutn.Repositorio.UsuarioRepo;
import ddsutn.Seguridad.Usuario.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorSvc {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Administrador findByUsuario(String usuario) {
        return usuarioRepo.findByUsuario(usuario).orElse(null);
    }

}
