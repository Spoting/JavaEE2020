package gr.hua.dit.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;


public class testingCreatingTable {

   public static void main(String[] args) {

           // create session factory
           SessionFactory factory = new Configuration().
                           configure("hibernate.cfg.xml")
                           .addAnnotatedClass(Department.class)
                           .addAnnotatedClass(Student.class)
                           .buildSessionFactory();
 
           // create session
           Session session = factory.getCurrentSession();
           
           try {
        	   List<Department> emp1Departs = new ArrayList<>();
        	   List<Department> emp2Departs = new ArrayList<>();
        	   List<Department> emp3Departs = new ArrayList<>();
        	   
        	   //Departments
                   Department dep1 = new Department();
                   dep1.setLocation("Αθήνα");
                   dep1.setBeneficiaries(0);
                   dep1.setTotalStudents(100);
                   dep1.setName("Γεωγραφία");
                   Department dep2 = new Department();
                   dep2.setLocation("Αθήνα");
                   dep2.setBeneficiaries(0);
                   dep2.setTotalStudents(200);
                   dep2.setName("Πληροφορική");
                   Department dep3 = new Department();
                   dep3.setLocation("Αθήνα");
                   dep3.setBeneficiaries(0);
                   dep3.setTotalStudents(100);
                   dep3.setName("Φυσική");
                   Department dep4 = new Department();
                   dep4.setLocation("Αθήνα");
                   dep4.setBeneficiaries(0);
                   dep4.setTotalStudents(100);
                   dep4.setName("Μαθηματικά");
//                   
//                   emp1Departs.add(dep1);
//                   emp2Departs.add(dep2);
//                   emp2Departs.add(dep3);
//                   emp3Departs.add(dep4);
           
                   //Students
                   Student student1 = new Student();
                   student1.setEmail("stu1@mail.com");
                   student1.setFirstName("Μάκης");
                   student1.setLastName("Κάτι1");
                   student1.setActivated(0);
                   Student student2 = new Student();
                   student2.setEmail("stu2@mail.com");
                   student2.setFirstName("Άκης");
                   student2.setLastName("Κάτι2");
                   student2.setActivated(0);
                   Student student3 = new Student();
                   student3.setEmail("stu3@mail.com");
                   student3.setFirstName("Λάκης");
                   student3.setLastName("Κάτι3");
                   student3.setActivated(0);
                   Student student4 = new Student();
                   student4.setEmail("stu4@mail.com");
                   student4.setFirstName("Ασημάκης");
                   student4.setLastName("Κάτι4");
                   student4.setActivated(1);
                   Student student5 = new Student();
                   student5.setEmail("stu5@mail.com");
                   student5.setFirstName("Μπάμπης");
                   student5.setLastName("Κάτι5");
                   student5.setActivated(1);
                   Student student6 = new Student();
                   student6.setEmail("stu6@mail.com");
                   student6.setFirstName("Γεώργιος");
                   student6.setLastName("Κάτι6");
                   student6.setActivated(1);
                   
                   
                   //Forms
                   Form form1 = new Form();
                   form1.setAnnualIncome(10000);
                   form1.setParentalStatus(false);
                   form1.setSiblingStudents(2);
                   form1.setResdence("Θεσσαλονίκη");
                   Form form2 = new Form();
                   form2.setAnnualIncome(15000);
                   form2.setParentalStatus(true);
                   form2.setSiblingStudents(0);
                   form2.setResdence("Πάτρα");
                   Form form3 = new Form();
                   form3.setAnnualIncome(20000);
                   form3.setParentalStatus(false);
                   form3.setSiblingStudents(3);
                   form3.setResdence("Αθήνα");
                   
                   //Applications
                   Application app1 = new Application();
                   app1.setApplicationForm(form1);
                   app1.setApproved(false);
                   app1.setCreationDate(LocalDateTime.now());
                   Application app2 = new Application();
                   app2.setApplicationForm(form2);
                   app2.setApproved(false);
                   app2.setCreationDate(LocalDateTime.now());
                   Application app3 = new Application();
                   app3.setApplicationForm(form3);
                   app3.setApproved(false);
                   app3.setCreationDate(LocalDateTime.now());
                   
                             
                   //Emloyees & Chief
                   Employee emp1 = new Employee();
                   emp1.setFirstName("Αρχηγός");
                   emp1.setLastName("Kati1");
                   emp1.setEmail("emp1@hua.gr");
                   emp1.setIsChief(1);
                   Employee emp2 = new Employee();
                   emp2.setFirstName("Employee2");
                   emp2.setLastName("Kati2");
                   emp2.setEmail("emp2@hua.gr");
                   emp2.setIsChief(0);
                   Employee emp3 = new Employee();
                   emp3.setFirstName("Employee3");
                   emp3.setLastName("Kati3");
                   emp3.setEmail("emp3@hua.gr");
                   emp3.setIsChief(0);

                   
                   
                   // start a transaction
                   session.beginTransaction();
                   
                   Employee e = session.get(Employee.class, 1);
                   System.out.println(e.getFirstName());
                   System.out.println(e.getDepartments().get(0).getName());
                   System.out.println(e.getDepartments().get(0).getStudents().get(0).getApplication().getCreationDate());
                   System.out.println(e.getDepartments().get(0).getStudents().get(0).getApplication().getApplicationForm().getAnnualIncome());
//                   Student s = session.get(Student.class, 1);
////                   s.setActivated(1);
//                   System.out.println(s.getApplication().getCreationDate());
//                   System.out.println(s.getApplication().getApplicationForm().getResdence());
//                   app1.setApplicationForm(form1);
//                   app1.setCreatedBy(s);
//                   session.save(app1);
//                   s.setApplication(app1);
                   //departments
//                   session.save(dep1);
//                   session.save(dep2);
//                   session.save(dep3);
//                   session.save(dep4);
                   //students
//                   Department d = session.get(Department.class, 1);
//                   
//                   student1.setDepartment(d);
//                   session.save(student1);
//                   Department d1 = session.get(Department.class, 1);
//                   Department d2 = session.get(Department.class, 2);
//                   System.out.println(d.getStudents().get(0).getFirstName());
                   
//                   session.save(emp1);
//                   session.save(emp2);
//                   session.save(emp3);
                   
//                 Student s = session.get(Student.class, 1);
//                 Department d = session.get(Department.class, 1);
//                 s.setDepartment(d);
                   
//                   Employee e =	session.get(Employee.class, 1);
////                   emp1Departs.add(d1);
////                   emp1Departs.add(d2);
////                   e.setDepartments(emp1Departs);
//                   System.out.println(e.getDepartments().get(0).getStudents().get(0).getFirstName());
//                   Student s = session.get(Student.class, 1);
//                   Department d = session.get(Department.class, 3);
//                   s.setDepartment(d);
	                   // commit transaction
                   session.getTransaction().commit();
                   System.out.println("Done!");
                   
           }
           finally {
                   factory.close();
           }
           
   }
}


//
//session.save(student);
//Student resStudent = session.get(Student.class, 1);
//System.out.println(resStudent.getFirstName());
//resStudent.getDepartment();
//System.out.println(resStudent.getDepartment().getName());
//// Application and form
//resStudent.setActivated(1);
//resStudent.setApplication(app);

//session.save(student1);
//session.save(student2);
//session.save(student3);
//session.save(student4);
//session.save(student5);
//session.save(student6);
//
//session.save(app1);
//session.save(app2);
//session.save(app3);
//
//session.save(emp1);
//session.save(emp2);
//session.save(emp3);
////
//
//Student stu = session.get(Student.class, 4);
//Employee emp = session.get(Employee.class, 2);
////System.out.println("Employee " + emp.getFirstName());
////System.out.println(emp.getDepartments());
////System.out.println("Created by" + emp.getApplications().get(0).getCreatedBy().getFirstName());
////System.out.println(emp.getApplications().get(0).getApplicationForm().getAnnualIncome());
////System.out.println(stu.getFirstName());
////System.out.println(stu.getApplication().getApplicationForm().getAnnualIncome());
//System.out.println(stu.getDepartment().getName());
//System.out.println(stu.getApplication());
//System.out.println(stu.getApplication().getApplicationForm().getResdence());
//System.out.println(stu.getApplication());
