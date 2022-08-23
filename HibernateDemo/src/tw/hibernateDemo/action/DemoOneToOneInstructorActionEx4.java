package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.InstructorDetail;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 101);
			if(instructorDetail!=null) {
				
				
			}else {
				System.out.println("查無資料");
			}
			
			
			
			session.getTransaction().commit();;
		} catch (Exception e) {
			
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
