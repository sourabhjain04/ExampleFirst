package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

	@RequestMapping("/home")
	public String Home() {
		System.out.println("this is Home page");
		return "Hi AIsiri";
		
	}
	@RequestMapping("/contact")
	public String contact() {
		System.out.println("this is contact page");
		return "contact";
		
	}
	
	

	
}
