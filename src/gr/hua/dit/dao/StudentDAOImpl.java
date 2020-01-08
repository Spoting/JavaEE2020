package gr.hua.dit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entities.Authorities;
import gr.hua.dit.entities.Department;
import gr.hua.dit.entities.Student;
import gr.hua.dit.entities.User;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDetailsDAO userDetailsDao;

	@Override
	public List<Student> getDepartmentStudents(int depId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createStudent(User user, int depId) {
		Session currentSession = sessionFactory.getCurrentSession();
		//////// MOVE THESE TO SERVICE///////////
		User u = new User();
		u.setFirstName("Giwrgos");
		u.setUsername("it21300");
		String encoded = new BCryptPasswordEncoder().encode("a123456a");
		u.setPassword(encoded);
		//////////////////////
		List<Authorities> auths = new ArrayList<Authorities>();
		Authorities auth = new Authorities();
		auth.setUser(u);
		auth.setAuthority("ROLE_STUDENT");
		auths.add(auth);
		u.setAuthorities(auths);
//		currentSession.save(u);

		Student s = new Student();
		s.setActivated(0);
//		s.setDepartment(studentDepartment);
		Department dep = currentSession.get(Department.class, depId);
		s.setDepartment(dep);
		s.setUser(u);

		currentSession.save(s);
	}

	@Override
	public Student getStudent(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = userDetailsDao.findUserByUsername(username);
		System.out.println(user.getFirstName());
		System.out.println(user.getAuthorities().get(0).getAuthority());
		System.out.println(user.getStudent().getDepartment().getName());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(String username) {
		// TODO Auto-generated method stub

	}

//	@Override
//	@Transactional
//	public void saveStudent(Student student) {
//		// TODO Auto-generated method stub
//		Session currentSession = sessionFactory.getCurrentSession();
//		currentSession.save(student);
//		System.out.println("Inserted");
//	}
//	
//	@Override
//	@Transactional
//	public List<Student> getStudents() {
//		Session currentSession = sessionFactory.getCurrentSession();
//        
//        // create a query
//        Query<Student> query = currentSession.createQuery("from Student", Student.class);
//        
//        
//        // execute the query and get the results list
//        List<Student> students = query.getResultList();
//        System.out.println(students.get(0).getUser().getFirstName());
//        //return the results
//        return students;
//	}

}
