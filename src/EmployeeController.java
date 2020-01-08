

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	//The class that we will use, will be moved to another folder
	class POJO {
		int id;
		String name;
		String email;
		String phone;

		public POJO(int id, String name, String email, String phone) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
		}
	}
	private List<POJO> x;
	//The MODEL ATTRIBUTE is a attribute that will be created whenever a call to this controller will happen.
	//In short, for ModelAttribute(x), x will be accessible to all JSPs that this controller will return.
	@ModelAttribute("studentList")
	public List<POJO> addStudentList(
			//RequestParam to change this Attribute value
			@RequestParam(value = "status", defaultValue = "PAYMENT", required = true) String status) {
		System.out.println("PRIN");
		System.out.println(x);
		x = new ArrayList<POJO>();
		POJO s1 = new POJO(1, "student1", "email@student1", "phone1");
		POJO s2 = new POJO(2, "student2", "email@student2", "phone2");
		POJO s3 = new POJO(3, "student3", "email@student3", "phone3");
		if (status.equals("PAYMENT")) { //If uri.param.status is "PAYMENT" return only 2 POJO
			x.add(s2);
			x.add(s3);
		} else { //Else return all POJO
			x.add(s1);
			x.add(s2);
			x.add(s3);
		}
		System.out.println("META");
		System.out.println(x);
		return x;
	}

	@RequestMapping("/showStudents")
	public String showStudents(HttpServletRequest request, Model model) {
//		String paramid = request.getParameter("deptId");

//		/** 
//		 * Query: List<Student> x = new ArrayList<Student>();
//		 * x = SELECT FROM Database.Students As s
//		 * LEFT JOIN Database.Departements AS d ON s.dep_id = d.id
//		 * WHERE s.activated = false;
//		 * */
//		System.out.println(x.get(0).id);
//		
//		model.addAttribute("studentList", x);
		return "show-students";
	}

	@RequestMapping("/activateStudent")
	public String activateStudent(HttpServletRequest request, Model model) {
		String log = "";
		String paramid = request.getParameter("studentId");
//		int id = Integer.parseInt(paramid);
//		System.out.println(id);
//		boolean result = Update student.activated=true WHERE student.id = id;
//		if ( result  = true) {
//			log = "Inserted";
//		} else {
//			log = "Was not Inserted";
//		}
		log = "Se gamaw giati pathses studentId: " + paramid;
		model.addAttribute("message", log);
//		return(log);
		return "show-students";
	}

	@RequestMapping("/getStudentsApplications")
	public String getStudentsApplications() {
		return null;
	}
}
