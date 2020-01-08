package gr.hua.dit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gr.hua.dit.entities.Authorities;
import gr.hua.dit.entities.Department;
import gr.hua.dit.entities.Student;

@Component
public class InitialDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
    @Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//EDW DATA GAMW
		// TODO Auto-generated method stub
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		
//		New Department
		Department d = new Department();
		d.setName("Pliroforiki");
		d.setLocation("Athina");
		d.setTotalStudents(80);
		departmentDAO.saveDepartment(d);
		//New Student
		Student s = new Student();
		s.setUsername("it213");
		s.setFirstName("MAKIS");
		
		String encoded = passwordEncoder.encode("it213");
		s.setPassword(encoded);
		
		Authorities auth = new Authorities();
		auth.setAuthority("ROLE_STUDENT");
		List<Authorities> stu_auths = new ArrayList<>();
		stu_auths.add(auth);
		s.setAuthorities(stu_auths);
		s.setEnabled(true);
		s.setDepartment(d);
		s.setActivated(0);
		studentDAO.saveStudent(s);
		
		
		//Outputs
//		Student s = studentDAO.getStudent(1);
//		System.out.println(s);
	}
	


}