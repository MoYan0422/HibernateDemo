package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernateDemo.model.CompanyBean;

public class DemoCompanyBeanActionEx1 {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		CompanyBean com1 = new CompanyBean(1001,"google");
		session.save(com1);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}
}
