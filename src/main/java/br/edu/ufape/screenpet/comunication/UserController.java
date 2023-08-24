package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v8")
public class UserController {
	@Autowired
	public Front front;
	
	@GetMapping("/usuario")
	public List<User> listUser() {
		return front.listUsers();
	}
	
	@PostMapping("/usuario")
	public User registerUser(@RequestBody User user) throws DuplicateUserException, DoesNotExistUserException, DisabledUserException {
		return front.saveUser(user);
	}
	
	@GetMapping("/usuario/{id}")
	public User printUser(@PathVariable long id) {
		return front.findUserId(id);
	}
	
	@PatchMapping("/usuario/{id}")
	public User updateUser(@PathVariable String email, @RequestBody User user) throws DuplicateUserException, DisabledUserException {
		user.setEmail(email);
		return front.saveUser(user);
	}
}