package poe.spring.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/name")
public class NamepageController {

	@GetMapping
	public String name (org.springframework.ui.Model model) {
		model.addAttribute("message2", "Ton nom please !!!!!!!!");
		return "name";
	}

//	@PostMapping
//	public String name2(String name, RedirectAttributes attr) { //redirect il faut faire pour recupérer un nom et le mettre dans une autre fct
//		System.out.println("name " + name);
//		attr.addAttribute("name", name);
//		return "redirect:/name/hello";
//
//	}
//
//	@GetMapping("/hello")
//	public String hello(String name, org.springframework.ui.Model model) {
//		model.addAttribute("message3", "hello " + name);
//		return "hello"; //il faut retourner le nom de l'html, va aller le chercher ainsi
//	}
}
