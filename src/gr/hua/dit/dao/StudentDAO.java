package gr.hua.dit.dao;
import java.util.List;

import gr.hua.dit.entities.Department;
import gr.hua.dit.entities.Student;
import gr.hua.dit.entities.User;

public interface StudentDAO {
	public List<Student> getDepartmentStudents(int depId);

	public void createStudent(User user, int depId);
	
	public Student getStudent(String username);

	public void deleteStudent(String username);
	
}
