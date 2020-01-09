package gr.hua.dit.controllers;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

	@GetMapping("/list")
	@Transactional
	public String userForm(Locale locale, Model model) {
		model.addAttribute("users", studentDAO.getStudents());
		return "editUsers";
	}

	@ModelAttribute("user")
	public Student formBackingObject() {
		return new Student();
	}

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") Student user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", studentDAO.getStudents());
			return "editUsers";
		}

		studentDAO.saveStudent(user);
		return "redirect:/";
	}

}
