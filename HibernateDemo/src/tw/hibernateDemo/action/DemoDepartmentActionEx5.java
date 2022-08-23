package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Department;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoDepartmentActionEx5 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Department department = session.get(Department.class, 5);
			
//			修改
//			if (department !=null) {
//				System.out.println(department.getId()+" : "+department.getDeptname());
//				department.setDeptname("放鬆");
//				System.out.println(department.getId()+" : "+department.getDeptname());
//				
//			}else {
//				System.out.println("查無該筆資料");
//			}
//			session.delete(department);
			
			session.delete(department);
			
			
			
			
			
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println("Something Wrong and Rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
				
	}
}
