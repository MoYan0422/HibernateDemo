package tw.hibernateDemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.CompanyBean;
import tw.hibernateDemo.service.CompanyService;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoCompanyServiceAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			CompanyService companyService = new CompanyService(session);
			CompanyBean company = companyService.select(1002);
			if(company!=null) {
				System.out.println(company.getCompanyID()+":"+company.getCompanyName());
				
			}else {
				System.out.println("查無資料");
			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("rollBack");
			session.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
