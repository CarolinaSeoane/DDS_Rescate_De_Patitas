package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String localhost(Model model) {
		return "redirect:/index";
	}

}
