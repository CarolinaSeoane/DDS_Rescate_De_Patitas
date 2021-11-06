package ddsutn.Servicios;

import ddsutn.Business.Mascota.Mascota;
import ddsutn.Repositorio.MascotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaSvc {

    @Autowired
    private MascotaRepo mascotaRepo;

    public void save(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

}
