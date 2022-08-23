package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Instructor;
import tw.hibernateDemo.model.InstructorDetail;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor ins1 = new Instructor();
			ins1.setName("Jerry");
			
			InstructorDetail detail1 = new InstructorDetail();
			detail1.setEmail("jerry666@gmail.com");
			detail1.setPhone("3345678");
			
			ins1.setInstructorDetail(detail1);
			
			// 因為有做 Cascade 連動，所以 detail1 也會轉移到 Persistent 狀態
			session.save(ins1);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
