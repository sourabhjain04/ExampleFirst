package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	/*
	 * @RequestMapping("/index") public String home() {
	 * System.out.println("this is out confermation Index views"); return "index";
	 * 
	 * }
	 */
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("this is out confermation about views");
		return "about";
		
	}
}
