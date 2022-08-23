package tw.hibernateDemo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateDemo.util.HibernateUtil;

public class MyMemberDao {

	private SessionFactory factory;

	public MyMemberDao() {
		this.factory = HibernateUtil.getFactory();
	}

	public MyMember queryUsernameAndPwd(String userName, String pwd) {
		Session session = factory.getCurrentSession();
		String hql = "from MyMember m where m.memberName = :name and m.memberPassword = :pwd";
		try {
			MyMember result = session.createQuery(hql, MyMember.class)
					.setParameter("name", userName)
					.setParameter("pwd", pwd).getSingleResult();
			return result;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
