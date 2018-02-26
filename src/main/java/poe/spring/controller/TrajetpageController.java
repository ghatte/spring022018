package poe.spring.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.LoginForm;
import poe.spring.Trajet;
import poe.spring.TrajetForm;
import poe.spring.TrajetManagerService;
import poe.spring.TrajetRepository;

@Controller
@RequestMapping("/trajet")
public class TrajetpageController {

	@Autowired
	TrajetManagerService trajetManagerService;

	@Autowired
	TrajetRepository trajetRepository;

	@GetMapping
	public String trajet (TrajetForm form) {
		return "trajet";
	}

	@PostMapping
	public String save(@Valid TrajetForm form,
			RedirectAttributes attr) { 
		trajetManagerService.signup(form.getUser(), form.getDepart(), form.getArrive(), form.getDate(), form.getPrix(), form.getPlace());
		return "redirect:/trajet";

	}

	@GetMapping("/listtrajet")
	public String list(Model model) {
		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		model.addAttribute("trajets", trajets);
		return "/trajet/listtrajet"; 

	}

	@GetMapping("/user")
	public String list2(Long id, Model model) {
		List<Trajet> list = trajetManagerService.listid(id);
		model.addAttribute("trajets", list);
		return "/trajet/user";

	}
	
	@GetMapping(path = "/search")
	public String search(TrajetForm form) {
		return "/trajet/search";
	}
	
	@PostMapping(path = "/search")
	public String list3(@RequestParam(required = false) String ville, Model model ) {
		List<Trajet> list = trajetRepository.findByDepartLike(ville);
		model.addAttribute("trajets", list);
		return "/trajet/search";
				
	}
	
}
