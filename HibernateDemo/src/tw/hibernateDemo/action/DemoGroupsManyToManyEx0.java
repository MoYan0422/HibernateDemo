package tw.hibernateDemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.model.Friend;
import tw.hibernateDemo.model.MyGroup;
import tw.hibernateDemo.util.HibernateUtil;

public class DemoGroupsManyToManyEx0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Friend friend = session.get(Friend.class,3);
			Set<MyGroup> myGroups = friend.getMyGroups();
			Iterator<MyGroup> iterator = myGroups.iterator();
			while (iterator.hasNext()) {
				MyGroup next = iterator.next();
				if (next.getGroupName().equals("work")) {
					iterator.remove();
					System.out.println("已刪除");
				}
				
			}
			
			
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
