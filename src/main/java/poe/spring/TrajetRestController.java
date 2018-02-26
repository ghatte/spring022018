package poe.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trajet")
public class TrajetRestController {
	
	@Autowired
	TrajetManagerService trajetManagerService;
	
	@Autowired
	TrajetRepository trajetRepository;
	
	@Autowired
	UserManagerService userManagerService;
	
	@PostMapping
	public Trajet save(@RequestBody ProposerUnTrajetDto trajetDto) throws Exception {
		
		Trajet savedTrajet = trajetManagerService.signup(
                trajetDto.getUser(),
                trajetDto.getDepart(),
                trajetDto.getArrive(),
                trajetDto.getDate(),
                trajetDto.getPrix(),
                trajetDto.getPlace()
        );
		
		return savedTrajet;
	}
	
	@GetMapping(path = "/trajet")
	public List<Trajet> getUser() {
		List<Trajet> list = trajetManagerService.list();
		return list;
	}
	
	@GetMapping(path = "/findone")
	public List<Trajet> getUser(long id) {
		List<Trajet> list = trajetManagerService.listid(id);
		return list;
	}
	
	@GetMapping(path = "/search/{ville}")
	public List<Trajet> list3(@PathVariable("ville") String ville) {
		
		return trajetRepository.findByDepartLike(ville);
	}
	
	
	
//	@GetMapping(path = "/findbyville")
//	public List<Trajet> getUser(String ville) {
//		List<Trajet> list = trajetManagerService.listville(ville);
//		return list;
//	}
	

}
