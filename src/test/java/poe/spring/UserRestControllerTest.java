package poe.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRestControllerTest {

	//	@Test
	//    public void checkuserCreation() {
	//        assertThat("toto").isEqualTo("toto");
	//    }

	@Autowired
	UserManagerService userManagerService;

	@Autowired
	UserRepository userRepository;

	@Test //test d'integrations
	public void checkUserCreation() {
		String login = "moitie";

		User createdUser = userManagerService.signup(login, "toi");

		long createdUserId = createdUser.getId();
		User user = userRepository.findOne(createdUserId);

		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
	}

	@Test
	public void checkUserdeletion() {
		User createdUser = userManagerService.signup("moittr", "toi");
		long createdUserId = createdUser.getId();
		User user2 = userRepository.findOne(createdUserId);
		assertThat(user2).isNotNull();
		
		userManagerService.delete(createdUserId);
		User user = userRepository.findOne(createdUserId);
		assertThat(user).isNull();
		
		
	}
}
