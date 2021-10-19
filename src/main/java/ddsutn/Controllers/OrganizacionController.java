package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Servicios.OrganizacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/organizaciones")
public class OrganizacionController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    @ResponseBody
    @RequestMapping("")
    public List<Organizacion> findAll(){
        return organizacionSvc.findAll();
    }

}
