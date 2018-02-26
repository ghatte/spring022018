package poe.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginCreationDelegate loginCreationDelegate;



	public User signup(String login, String password) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);


		Boolean loginsize = loginCreationDelegate.loginsize(login);
		Boolean loginForbidden = loginCreationDelegate.loginForbidden(login);

		if (loginsize == true & loginForbidden == true & userRepository.findByLogin(login) == null) {
			userRepository.save(user);
		}
		else {
			System.out.println(login + " n'est pas bon");
		}

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

