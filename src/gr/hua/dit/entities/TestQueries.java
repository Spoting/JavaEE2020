package gr.hua.dit.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Department.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
/////////TEST QUERIES////////////
		
			Employee e = session.get(Employee.class, 2);
			System.out.println("From Employee");
			System.out.println(e.getFirstName());
			
			System.out.println("Employee Departments Students");
			System.out.println(e.getDepartments().get(0).getName());
			System.out.println(e.getDepartments().get(0).getStudents().get(0).getFirstName());
			System.out.println(e.getDepartments().get(0).getStudents().get(0).getApplication().getApplicationForm().getAnnualIncome());
			System.out.println(e.getDepartments().get(0).getStudents().get(1).getFirstName());
			System.out.println(e.getDepartments().get(0).getStudents().get(1).getApplication().getApplicationForm().getAnnualIncome());
			System.out.println(e.getDepartments().get(1).getName());
			System.out.println(e.getDepartments().get(1).getStudents().get(0).getFirstName());
			System.out.println(e.getDepartments().get(1).getStudents().get(0).getApplication().getApplicationForm().getAnnualIncome());
			System.out.println(e.getDepartments().get(1).getStudents().get(1).getFirstName());
			if (e.getDepartments().get(1).getStudents().get(1).getApplication() != null) {
				System.out.println(e.getDepartments().get(1).getStudents().get(1).getApplication().getApplicationForm().getAnnualIncome());	
			} else {
				System.out.println("No form for this student");
			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
