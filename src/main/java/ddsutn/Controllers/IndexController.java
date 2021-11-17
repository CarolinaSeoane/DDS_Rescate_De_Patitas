package ddsutn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class IndexController {

	//@RequestMapping("/")
	//public String localhost(Model model) {
		//return "redirect:/index";
	//}
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

}
