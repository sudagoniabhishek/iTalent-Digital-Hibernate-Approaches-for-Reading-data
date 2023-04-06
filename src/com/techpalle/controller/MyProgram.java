package com.techpalle.controller;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.techpalle.model.Student;

public class MyProgram {

	public static void main(String[] args) {
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
	
		
		
// code for inserting values into tables 
		
		/*Student s1=new Student(1,"abhishek","java");
		Student s2=new Student(2,"sanju","python");
		Student s3=new Student(3,"bhanu","dotnet");
		
		s.save(s1);
		s.save(s2);
		s.save(s3);
		*/
		
		
		
		

		
		
		
//Write the code for fetching values from tables

		
		
		
// 1st approach
		
   System.out.println("---1st approach---");
	Student stud1=s.get(Student.class, 1);
		
		System.out.println(stud1.getSno());
		System.out.println(stud1.getSname());
		System.out.println(stud1.getSub());
		
		System.out.println("------------------");
		
	Student stud2=s.get(Student.class, 2);
		
		System.out.println(stud2.getSno());
		System.out.println(stud2.getSname());
		System.out.println(stud2.getSub());
		
		System.out.println("------------------");
		
	Student stud3=s.get(Student.class, 3);
		
		System.out.println(stud3.getSno());
		System.out.println(stud3.getSname());
		System.out.println(stud3.getSub());
		
		System.out.println("------------------");
		
		
		
		
		
		
//2nd approach 
// By using "HQL" [Hibernate Query Language]
		
	
		 
		 
		Query q=s.createQuery("from Student");
		List<Student> ls=q.list();
		
      System.out.println("---2nd approach---");
		 
		 
		for(Student item:ls) {
			
			 System.out.println(item.getSno());
			 System.out.println(item.getSname());
			 System.out.println(item.getSub());
			 
			 System.out.println("------------------");
			 
		}
		
		
		
		
// select sname from student where sno>=2		
        int check = 2;
		Query q1=s.createQuery("from Student where sno >= :e");
		q1.setParameter("e", check);
		
		List<Student> ls1=q1.list();
		
     
		 
		 
		for(Student e:ls1) {
			
		
			 System.out.println(e.getSname());
			
			 
			 System.out.println("------------------");
			 
		}
		
		
		
		
		
		
		
		
// 3rd approach
// By using Criteria and Restrictions interfaces
		

		
		
		
		Criteria c=s.createCriteria(Student.class);
		c.add(Restrictions.ge("sno", 2));
		
		List<Student> lsCri=c.list();
		System.out.println("---3rd approach---");
		
		for(Student item:lsCri) {
			
			 System.out.println(item.getSno());
			 System.out.println(item.getSname());
			 System.out.println(item.getSub());
			 
			 System.out.println("------------------");
			 
		}
		
		
// select sname from student where sname like 'a%' and sno<4 
		
		Criteria c1=s.createCriteria(Student.class);
		
		Criterion r1=Restrictions.ilike("sname", "a%");
		Criterion r2=Restrictions.lt("sno",4 );
		
		LogicalExpression exp=Restrictions.and(r1,r2);
		
		c1.add(exp);
		List<Student> lsEmp=c1.list();
		
		for(Student s1 : lsEmp) {
			
			System.out.println(s1.getSname());
			
		}
		
		
		
		
		
		
		
		
		
		t.commit();
		s.close();
		sf.close();

	}

}
