package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Servicios.OrganizacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/organizaciones")
@CrossOrigin
public class OrganizacionController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    @ResponseBody
    @RequestMapping()
    public List<Organizacion> findAll(){
        return organizacionSvc.findAll();
    }

    @PostMapping(value = "/modificar")
    public ResponseEntity modificarParametros(@RequestBody Organizacion organizacion) {
        organizacionSvc.save(organizacion);
        return ResponseEntity.status(200).build();
    }

}
