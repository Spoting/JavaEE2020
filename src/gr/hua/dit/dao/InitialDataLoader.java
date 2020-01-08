package gr.hua.dit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gr.hua.dit.entities.Authorities;
import gr.hua.dit.entities.Department;
import gr.hua.dit.entities.Employee;
import gr.hua.dit.entities.Student;
import gr.hua.dit.entities.User;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Session currentSession = sessionFactory.getCurrentSession();
		// EDW DATA GAMW
		// TODO Auto-generated method stub
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");
		System.out.println("SAS GAMAW OLOUS");

		/////// Departments
		Department d1 = new Department();
		d1.setName("Πληροφορική");
		d1.setLocation("Αθήνα");
		d1.setTotalStudents(80);
		departmentDAO.saveDepartment(d1);

		Department d2 = new Department();
		d2.setName("Διαιτολογία");
		d2.setLocation("Αθήνα");
		d2.setTotalStudents(100);
		departmentDAO.saveDepartment(d2);

		Department d3 = new Department();
		d3.setName("Γεωγραφία");
		d3.setLocation("Αθήνα");
		d3.setTotalStudents(50);
		departmentDAO.saveDepartment(d3);

		Department d4 = new Department();
		d4.setName("Οικιακή Οικονομία");
		d4.setLocation("Athina");
		d4.setTotalStudents(50);
		departmentDAO.saveDepartment(d4);

		//Roles
		Authorities sAuth = new Authorities();
		sAuth.setAuthority("ROLE_STUDENT");
		currentSession.save(sAuth);

		Authorities cAuth = new Authorities();
		cAuth.setAuthority("ROLE_CHIEF");
		currentSession.save(cAuth);

		Authorities aAuth = new Authorities();
		aAuth.setAuthority("ROLE_ADMIN");
		currentSession.save(aAuth);
		
		Authorities eAuth = new Authorities();
		eAuth.setAuthority("ROLE_EMP");
		currentSession.save(eAuth);
		
		//Users Roles
		List<Authorities> stu_auths = new ArrayList<>();
		stu_auths.add(sAuth);
		List<Authorities> emp_auths = new ArrayList<>();
		emp_auths.add(eAuth);
		List<Authorities> chief_auths = new ArrayList<>();
		chief_auths.add(cAuth);
		chief_auths.add(eAuth);
		List<Authorities> admin_auths = new ArrayList<>();
		admin_auths.add(aAuth);

		// Passwords
		String studPass = passwordEncoder.encode("it@123");
		String empPass = passwordEncoder.encode("emp@123");
		String adminPass = passwordEncoder.encode("admin@123");

		// New Admin
		User u = new User();
		u.setAuthorities(admin_auths);
		u.setEnabled(true);
		u.setUsername("admin");
		u.setPassword(adminPass);
		u.setFirstName("Ανάργυρος");
		u.setLastName("Τσαδίμας");
		userDAO.saveAdmin(u);

		// New Employees & Chief
		Employee c = new Employee();
		c.setAuthorities(chief_auths);
		c.setEnabled(true);
		c.setUsername("chief");
		c.setPassword(empPass);
		c.setFirstName("Γιώργος");
		c.setLastName("Καραγιώργος");
		c.setChief(true);
		List<Department> chiefDeps = new ArrayList<>();
		chiefDeps.add(d1);
		c.setDepartments(chiefDeps);
		employeeDAO.saveEmployee(c);

		Employee e1 = new Employee();
		e1.setAuthorities(chief_auths);
		e1.setEnabled(true);
		e1.setUsername("emp1");
		e1.setPassword(empPass);
		e1.setFirstName("Τάσος");
		e1.setLastName("Πασχάλης");
		e1.setChief(false);
		List<Department> e1Deps = new ArrayList<>();
		e1Deps.add(d2);
		e1Deps.add(d3);
		e1.setDepartments(e1Deps);
		employeeDAO.saveEmployee(e1);

		Employee e2 = new Employee();
		e2.setAuthorities(chief_auths);
		e2.setEnabled(true);
		e2.setUsername("emp2");
		e2.setPassword(empPass);
		e2.setFirstName("Αποστόλης");
		e2.setLastName("Παππάς");
		e2.setChief(false);
		List<Department> e2Deps = new ArrayList<>();
		e2Deps.add(d4);
		e2.setDepartments(e2Deps);
		employeeDAO.saveEmployee(e2);

//		//New Students
//		
//		
//		
//		Student s = new Student();
//		s.setUsername("it213");
//		s.setFirstName("MAKIS");
//		s.setPassword(encoded);
//		
//		
//		
//		s.setAuthorities(stu_auths);
//		s.setEnabled(true);
//		s.setDepartment(d);
//		s.setActivated(0);
//		studentDAO.saveStudent(s);

//		Employee e = employeeDAO.getEmployee(2);
//		System.out.println(e.toString());
//		e.getAuthorities().get
		// Outputs
//		Student s = studentDAO.getStudent(1);
//		System.out.println(s);
	}

}