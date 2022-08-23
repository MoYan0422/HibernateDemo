package tw.hibernateDemo.action;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.BookUsers;
import tw.hibernateDemo.model.Books;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoBookOneToManyEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			BookUsers bookUsers = session.get(BookUsers.class, 1);
			Set<Books> books = bookUsers.getBooks();
			
			Books books1 = new Books();
			books1.setBooktitle("java入門到放棄到去世");
			books1.setPublicYear("2016-1");
			
			Books books2 = new Books();
			books2.setBooktitle("java從放棄喜歡到喜歡");
			books2.setPublicYear("2017-1");
			
			
			books.add(books1);
			books.add(books2);
			
			session.save(books1);
			session.save(books2);
			
			books1.setBookUsers(bookUsers);
			books2.setBookUsers(bookUsers);
			
			
			session.save(bookUsers);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			System.out.println("rollback");
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		

	}

}
