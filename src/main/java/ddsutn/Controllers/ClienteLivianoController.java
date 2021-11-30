package ddsutn.Controllers;

import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Servicios.OrganizacionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(value = "/cliente-liviano")
public class ClienteLivianoController {

    @Autowired
    private OrganizacionSvc organizacionSvc;

    @RequestMapping("/organizaciones")
    public String organizaciones(Model model) {
        List<Organizacion> organizacionList = organizacionSvc.findAll();
        model.addAttribute("organizaciones", organizacionList);
        return "Cliente_Liviano_Organizaciones";
    }

}
