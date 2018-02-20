package poe.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User signup(String login, String password) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		
		userRepository.save(user);
		
		
		return user;
	}
	
	public List<User> list() {
		List<User> list = (List<User>) userRepository.findAll();
		return list;
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}
	
	public void update(Long id, String login) {
		User user = userRepository.findOne(id); 
		user.setLogin(login);
		userRepository.save(user);
		
	}
	
	public User findone(Long id) {
		User user = userRepository.findOne(id); 
		return user;
	}
}
