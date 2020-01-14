package spring.mvc.demo1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(path = { "/", "/index.html" }, method = RequestMethod.GET)
	public String index(Model model, @RequestParam(name = "name") String name) {
		logger.warn("Name = Ashish" );
		model.addAttribute("name", name);
		return "index";
	}

}
