package poe.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TrajetManagerService {
	
	@Autowired
	private TrajetRepository trajetRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Trajet signup(Long userId, String depart, String arrive, Date date, Double prix, int place) {
		Trajet trajet = new Trajet();
		trajet.setDepart(depart);
		trajet.setArrive(arrive);
		trajet.setDate(date);
		trajet.setPrix(prix);
		trajet.setPlace(place);
		
		User user = userRepository.findOne(userId);
		trajet.setUser(user);
		user.getTrajet().add(trajet);
		
		trajetRepository.save(trajet);
		userRepository.save(user);
		return trajet;
		
	}
	
	public List<Trajet> list() {
		List<Trajet> list = (List<Trajet>) trajetRepository.findAll();
		return list;
	}

	public List<Trajet> listid(Long id) {
		User user = userRepository.findOne(id); 
		List<Trajet> list = (List<Trajet>) user.getTrajet();
		return list;
	}
	

	
//	public List<Trajet> findByVilleDepartLike(String ville) {
//		List<Trajet> list = (List<Trajet>) trajetRepository.findAll();
//		Trajet trajet;
//		trajet.setArrive(ville);
//		trajet.setDepart(ville);
//		
//		return list;
		
		
//		Trajet trajet = trajetRepository.
//		User user = userRepository.findOne(ville); 
//		List<Trajet> list = (List<Trajet>) user.getTrajet();
//		return list;
//	}
	
}
