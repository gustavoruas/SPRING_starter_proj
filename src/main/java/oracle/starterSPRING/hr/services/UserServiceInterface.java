package oracle.starterSPRING.hr.services;

import java.util.List;

import oracle.starterSPRING.hr.models.User;

public interface UserServiceInterface {
	
	public List<User> getAllUsers();
	
	public User getUserByName(String name);
	
	public User saveUser(User usr);
	
	public String deleteUser(Long id);	
	

}
