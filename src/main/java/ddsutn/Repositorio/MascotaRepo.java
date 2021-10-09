package ddsutn.Repositorio;

import ddsutn.Business.Mascota.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepo extends CrudRepository<Mascota, Long> {

}
