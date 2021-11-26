package ddsutn.Business.Mascota.DTOs;

import ddsutn.Business.Hogares.Ubicacion;
import ddsutn.Business.Mascota.Foto.Foto;
import ddsutn.Business.Mascota.TipoMascota;
import java.util.Set;

public class MascotaPerdidaDTO {

    private Set<Foto> fotos;
    private String estado;
    private Ubicacion ubicacion;
    private TipoMascota tipo;

}
