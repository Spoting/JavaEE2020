package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entities.User;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(user);
}
	
	@Override
	public User findUserByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUserByAuthority(String authority) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<User> query = currentSession.createQuery("select u from User u left join u.username r where r.roleName=:roleName").setParameter("authority", authority);
		return null;
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

}
