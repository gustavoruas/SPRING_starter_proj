package oracle.starterSPRING.hr.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import oracle.starterSPRING.hr.models.User;
import oracle.starterSPRING.hr.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository usrRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User usr = this.getUserByName(username);
		
		if(usr==null) {
			throw new UsernameNotFoundException("user: "+username+"not found.");
		};
		
		
		return new org.springframework.security.core.userdetails.User(usr.getUsername(), usr.getPassword(), getGrantedAuthorities(usr));
		
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthorities;
}		
	
		
	@Autowired
	public UserService(UserRepository usrrep) {
		this.usrRepository = usrrep;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usrRepository.findAll();
	}

	
	public User getUserByName(String name) {
		
		User usr = manager.createNamedQuery("queries.userReturnPassword", User.class)
				.setParameter(0, name)
				.getSingleResult();		
		
		return usr;
	}

	
	public User saveUser(User usr) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String deleteUser(Long id) {
		
		try {
			usrRepository.deleteById(id);
			return "User deleted";
			
		}catch(JpaSystemException je) {
			return "Unable to delete user: " + je.toString();
		}
		
	}


}
