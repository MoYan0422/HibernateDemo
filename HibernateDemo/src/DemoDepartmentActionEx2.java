import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Department;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoDepartmentActionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Department department = new Department();
		department.setDeptname("test");
		session.save(department);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	
	
	
	}

}
