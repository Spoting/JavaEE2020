package gr.hua.dit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "total_students")
	private int totalStudents;
	@Column(name = "beneficaries")
	private int beneficiaries;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "dept_id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
	private List<Student> students;
	
	
	public Department() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public int getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(int beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudent(List<Student> students) {
		this.students = students;
	}

	
//	private Employee manager;
	
	
}
