package ddsutn.Servicios;

import ddsutn.Business.Persona.Duenio;
import ddsutn.Business.Publicacion.PublicacionInteresado;
import ddsutn.Repositorio.PersonaRepo;
import ddsutn.Repositorio.PublicacionInteresadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionInteresadoSvc {

	@Autowired
	private PublicacionInteresadoRepo publicacionInteresadoRepo;

	public void save(PublicacionInteresado publicacionInteresado) {
		publicacionInteresadoRepo.save(publicacionInteresado);
	}

}
