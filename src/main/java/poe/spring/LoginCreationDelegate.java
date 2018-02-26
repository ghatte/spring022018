package poe.spring;

import org.springframework.stereotype.Service;

@Service
public class LoginCreationDelegate {

	public boolean loginsize(String login) {
		Boolean loginsize = false;

		if (login.length() > 3 & login.length() < 11) {
			loginsize = true; }

		return loginsize;
	}


	public boolean loginForbidden(String login) {
	Boolean loginForbidden = false;

	if (login.equals("toto") || login.equals("titi") || login.equals("tata")) {
		loginForbidden = false; 
		}
	else loginForbidden = true;
		
	return loginForbidden;
}

}
