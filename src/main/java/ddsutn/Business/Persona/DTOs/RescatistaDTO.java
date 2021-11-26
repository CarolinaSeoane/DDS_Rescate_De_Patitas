package ddsutn.Business.Persona.DTOs;

import ddsutn.Business.Mascota.DTOs.MascotaPerdidaDTO;
import ddsutn.Business.Persona.Contacto;
import ddsutn.Business.Persona.TipoDcto;
import java.util.Date;
import java.util.List;

public class RescatistaDTO {

    private Long id;
    private TipoDcto tipoDocumento;
    private String nroDocumento;
    private Date fechaDeNacimiento;
    private List<Contacto> otrosContactos;
    private String domicilio;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String formasNotificacion;
    private MascotaPerdidaDTO mascotaPerdidaDTO;

}
