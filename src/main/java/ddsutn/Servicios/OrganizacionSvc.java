package ddsutn.Servicios;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Repositorio.OrganizacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizacionSvc {

    @Autowired
    OrganizacionRepo organizacionRepo;

    public List<Organizacion> findAll() {
        return (List<Organizacion>) organizacionRepo.findAll();
    }

}
