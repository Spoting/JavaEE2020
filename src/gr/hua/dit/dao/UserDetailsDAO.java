package gr.hua.dit.dao;
import java.util.List;

import gr.hua.dit.entities.User;

public interface UserDetailsDAO {
	
	void save(User user);
	
	User findUserByUsername(String username);
	
	List<User> getAllUserByAuthority(String authority);
	
	void deleteUser(String username);
}
