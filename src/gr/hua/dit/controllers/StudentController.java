//package gr.hua.dit.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import gr.hua.dit.dao.StudentDAO;
//import gr.hua.dit.entities.Student;
//import gr.hua.dit.entities.User;
//
//@Controller
//@RequestMapping("/student")
//public class StudentController {
//
//	@Autowired
//	private StudentDAO studentDAO;
////
////	@RequestMapping("/list")
////	public String listStudents(Model model) {
////		// get customers from dao
////		List<Student> students = studentDAO.getStudents();
////
////		// add the customers to the model
////		model.addAttribute("students", students);
////		
////		System.out.println(students.get(0).getApplication().getApplicationForm().getAnnualIncome());
////		return "list-students";
////	}
//
//	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
//	public String saveStudent(@ModelAttribute("student") User user, @RequestParam("department") int depId) {
////		System.out.println(user.getFirstName());
////		System.out.println(depId);
////		// get customers from dao
//////		Student s = new Student();
//////		s.setActivated(1);
//////		studentDAO.saveStudent(s);
////
////		// add the customers to the model
//////        model.addAttribute("student", students);
//
//		return "redirect:/customer/list-students";
//	}
//}
