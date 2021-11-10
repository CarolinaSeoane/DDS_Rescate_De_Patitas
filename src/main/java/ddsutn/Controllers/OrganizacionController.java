package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Servicios.OrganizacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
