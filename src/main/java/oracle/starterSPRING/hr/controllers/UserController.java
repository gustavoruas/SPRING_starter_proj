package oracle.starterSPRING.hr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oracle.starterSPRING.hr.models.User;
import oracle.starterSPRING.hr.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userServ;
	
	@Autowired
	public UserController(UserService usrServ) {
		this.userServ = usrServ;
	}
	
	@RequestMapping("/test")
	public String testReturn() {
		return "<h> Testing controller for user </h><br>";
	}
	
	@RequestMapping("/{name}")
	public User getUserByName(@PathVariable String name) {
		
		return userServ.getUserByName(name.toUpperCase());
	}

}
