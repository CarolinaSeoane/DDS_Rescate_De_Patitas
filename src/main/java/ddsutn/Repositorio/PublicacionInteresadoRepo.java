package ddsutn.Repositorio;

import ddsutn.Business.Publicacion.PublicacionInteresado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionInteresadoRepo extends CrudRepository<PublicacionInteresado, Long> {

}
