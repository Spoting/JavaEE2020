package gr.hua.dit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends User {
	
	@Column(name = "is_chief")
	private int isChief;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private List<Department> departments;
	
	public Employee() {
		super();
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public int getIsChief() {
		return isChief;
	}

	public void setIsChief(int isChief) {
		this.isChief = isChief;
	}
	
	
}
