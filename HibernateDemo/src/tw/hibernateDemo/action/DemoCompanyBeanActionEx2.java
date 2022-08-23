package tw.hibernateDemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernateDemo.model.CompanyBean;

public class DemoCompanyBeanActionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		CompanyBean company = new CompanyBean(1002, "Meta");
		Serializable identifier = session.save(company);
		System.out.println("identifier" + identifier);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
