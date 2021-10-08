package ddsutn.Repositorio;

import ddsutn.Business.Publicacion.Pregunta.Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepo extends CrudRepository<Pregunta, Long> {

}
