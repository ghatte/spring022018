package poe.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationDelegateTest {
	
	
	@Autowired
	LoginCreationDelegate loginCreationDelegate;
	
	@Test //test unitaire
	public void checkloginsize() {
		boolean createdUser = loginCreationDelegate.loginsize("tot");
		assertThat(createdUser).isFalse();
}
	@Test
	public void checkloginForbidden() {
		boolean createdUser = loginCreationDelegate.loginForbidden("toto");
		assertThat(createdUser).isFalse();
	}
	
	
}