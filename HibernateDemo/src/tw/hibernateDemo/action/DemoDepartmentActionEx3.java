package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Department;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoDepartmentActionEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Department department = new Department();
		department.setDeptname("按摩");
		session.save(department);
		session.getTransaction().commit();		
		HibernateUtil.closeSessionFactory();
		
		
	}

}
