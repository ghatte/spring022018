package poe.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public User save(@RequestBody User user) {
		User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		return savedUser;
	}

	
	@GetMapping(path = "/user")
	public List<User> getUser() {
		List<User> list = userManagerService.list();
		return list;
	}
	
	@GetMapping(path = "/findone")
	public User findone(Long id) {
		User user = userManagerService.findone(id);
		return user;
	}
	
	@GetMapping(path = "/delete")
	public void deleteUser(Long id) {
		userManagerService.delete(id);
		
	}

	@PostMapping(path = "/update")
	public void updateUser(Long id, String login) {
		 userManagerService.update(id, login);
	}
}


