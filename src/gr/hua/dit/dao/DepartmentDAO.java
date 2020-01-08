package gr.hua.dit.dao;
import java.util.List;

import gr.hua.dit.entities.Department;

public interface DepartmentDAO {
	public void createDepartment(Department department);
	
	public List<Department> getDepartments();
	
	public Department getDepartment(int id);
	
	public void deleteDepartment(int id);
	
	public List<Department> getEmployeeDepartments(int empId);
	
	public void updateDepartment(int id);
}
