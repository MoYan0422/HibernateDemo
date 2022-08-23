



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tw.hibernateDemo.model.Department;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoDepartmentEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		
		try {
			tx = session.beginTransaction();
			Department department = new Department();
			department.setDeptname("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt  frett");
			session.save(department);
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("Something wrong and Rollback");
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
