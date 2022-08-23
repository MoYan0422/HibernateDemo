package tw.hibernateDemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernateDemo.model.Employee;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoHQLEx1 {
	
	public void queryEmployee() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee",Employee.class);
			List<Employee> employees = query.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.toString());
				
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public void queryEmployeeBySalary() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee where salary > 3000 and vacation>10",Employee.class);
			List<Employee> employees = query.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.toString());
				
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	public void queryEmployeeBySalaryWithParameter(Integer salary ,Integer vacation) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee where salary > :s and vacation > :v",Employee.class)
					.setParameter("s", salary)
					.setParameter("v", vacation);
					
					
					
			List<Employee> employees = query.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.toString());
				
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public void queryEmployeeByName(String name) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee where employeeName = :n",Employee.class)
					.setParameter("n", name);
					
					
					
					
			List<Employee> employees = query.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.toString());
				
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	public void updateSalaryByName(String name , Integer salary) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			String hql = "update Employee set salary = :s where employeeName = :name";
			session.createQuery(hql).setParameter("name", name).setParameter("s", salary).executeUpdate();
					
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("rollback");
			session.getTransaction().rollback();
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoHQLEx1 demoHQLEx1 = new DemoHQLEx1();
//		demoHQLEx1.queryEmployeeBySalary();
//		demoHQLEx1.queryEmployeeBySalaryWithParameter(30000, 10);
//		demoHQLEx1.queryEmployeeByName("Mary");
		demoHQLEx1.updateSalaryByName("Mary", 60000);;
	}

}
