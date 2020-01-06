package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entities.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(student);
		System.out.println("Inserted");
	}
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Student> query = currentSession.createQuery("from Student", Student.class);
        
        
        // execute the query and get the results list
        List<Student> students = query.getResultList();
        System.out.println(students.get(0).getFirstName());
        //return the results
        return students;
	}
	
	@Override
	public List<Student> getDepartmentStudents(int depId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(int id) {
		// TODO Auto-generated method stub
		
	}


}
