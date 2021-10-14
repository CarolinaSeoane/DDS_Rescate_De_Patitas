package ddsutn.Servicios;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import ddsutn.Repositorio.PublicacionDarEnAdopcionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionDarEnAdopcionSvc {
    @Autowired
    PublicacionDarEnAdopcionRepo publicacionDarEnAdopcionRepo;

    public List<PublicacionDarEnAdopcion> publicaciones() { return (List<PublicacionDarEnAdopcion>) publicacionDarEnAdopcionRepo.findAll();}
}
