package ddsutn.Repositorio;

import ddsutn.Seguridad.Usuario.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Long> {

}
