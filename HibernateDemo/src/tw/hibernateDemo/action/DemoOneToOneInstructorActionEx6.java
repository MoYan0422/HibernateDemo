package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Instructor;
import tw.hibernateDemo.model.InstructorDetail;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			if(instructor!=null) {
				InstructorDetail instructorDetail = new InstructorDetail();
				instructorDetail.setEmail("jerry7777@gmail.com");;
				instructorDetail.setPhone("334567111118");
				session.save(instructorDetail);
				instructor.setInstructorDetail(instructorDetail);
				System.out.println("新增成功");
				
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
