package gr.hua.dit.controllers;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.dao.ApplicationDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.entities.Application;
import gr.hua.dit.entities.Form;
import gr.hua.dit.entities.Student;
import gr.hua.dit.entities.User;

@RestController
@RequestMapping("/api")
public class StudentRestController {
		
	@Autowired
	private UserDAO userDao;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	
		// Get Student's Info
		@Transactional
		@GetMapping("/student/{username}")
		public Student getStudentInfo(@PathVariable String username) {
			User u = userDao.findByUserName(username);
			Student s = studentDAO.getStudent(u.getId());
			return s;
		}
		
		
		//TODO: VALE STOIXEIA EPIKOINWNIAS
		//Update Student's Info
		@Transactional
		@RequestMapping(value = "/student/{username}", method = RequestMethod.PUT, produces = { "application/json" })
		public Student updateStudentInfo(@PathVariable("username") String username, @RequestBody Student studentIn) {
			User u = userDao.findByUserName(username);
			Student s = studentDAO.getStudent(u.getId());
			s.setFirstName(studentIn.getFirstName());
			s.setLastName(studentIn.getLastName());
//			student.setId(u.getId());
			studentDAO.saveStudent(s);
//			System.out.println(student.getFirstName());
			return null;
		}
		
		//Create Student's Application/Form
		@Transactional
        @RequestMapping(value = "/application/{username}", method = RequestMethod.PUT, produces = { "application/json" })
		public Application saveApplication(@PathVariable("username") String username, @RequestBody Form form) {
			System.out.println(form.getAnnualIncome());
			User u = userDao.findByUserName(username);
			Student s = studentDAO.getStudent(u.getId());
			
			Application app = new Application();
			app.setApplicationForm(form);
			app.setCreationDate(LocalDateTime.now());
			app.setCreatedBy(s);
			applicationDAO.saveApplication(app);
			
			return app; 
		}
		
        //TODO: GET function() --> Show Student's Ranking and Show if he is allowed to receive Ailment
		/**
		 * 
		 */
		
		//FOR MAKING REST CLIENT
//		https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
//		https://www.baeldung.com/rest-template
}
