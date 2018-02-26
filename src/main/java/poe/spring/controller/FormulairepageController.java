package poe.spring.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.LoginForm;
import poe.spring.UserManagerService;

@Controller
@RequestMapping("/formulaire")
public class FormulairepageController {
	
	@Autowired
	UserManagerService userManagerService;


	@GetMapping
	public String formulaire (LoginForm form) {
		return "formulaire";
	}
	
//	@PostMapping
//	public String save(String login, String password, RedirectAttributes attr) { //redirect il faut faire pour recupérer un nom et le mettre dans une autre fct
//		System.out.println("login " + login + " password " + password);
//		attr.addAttribute("login", login);
//		attr.addAttribute("password", password);
//		userManagerService.signup(login, password);
//		return "redirect:/formulaire/hello";
//
//	}
//	
	 @PostMapping
	    public String save(@Valid LoginForm form,
	                       BindingResult bindingResult,
	                       RedirectAttributes attr) {

	        System.out.println("login " + form.getLogin());
	        System.out.println("password " + form.getPassword());

	        if (bindingResult.hasErrors()) {
	            return "formulaire";
	        }

	        userManagerService.signup(form.getLogin(), form.getPassword());
	        attr.addAttribute("login", form.getLogin());
	        return "redirect:/formulaire/hello";
	    }
	
		@GetMapping("/hello")
	public String hello(String login, org.springframework.ui.Model model) {
		model.addAttribute("message3", "hello " + login);
		return "hello"; //il faut retourner le nom de l'html, va aller le chercher ainsi
	}
}
