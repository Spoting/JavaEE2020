package gr.hua.dit.dao;
import java.util.List;

import gr.hua.dit.entities.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public void saveStudent(Student student);
	
	public Student getStudent(int id);

	public void deleteStudent(int id);
	
	public void updateStudent(int id);
	
	public List<Student> getDepartmentStudents(int depId);

}
