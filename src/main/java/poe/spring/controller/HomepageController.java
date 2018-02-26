package poe.spring.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomepageController {
	
	@GetMapping
	public String index (org.springframework.ui.Model model) {
		model.addAttribute("message", "Welcome Lucie et Guillaume");
		return "index";
	}
	
	
	
}