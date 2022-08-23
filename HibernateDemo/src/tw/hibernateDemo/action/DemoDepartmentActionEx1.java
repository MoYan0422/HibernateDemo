package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernateDemo.model.Department;

public class DemoDepartmentActionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Department department = new Department();
		department.setDeptname("Human Resource");
		session.save(department);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		
	}

}
