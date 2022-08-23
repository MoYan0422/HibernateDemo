package tw.hibernateDemo.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
@WebFilter(urlPatterns = "/*")
public class OpenSessionInViewFilter extends HttpFilter implements Filter {
    
	private Session session;
	
    public OpenSessionInViewFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getFactory();
		this.session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Begin Transaction");
			
			chain.doFilter(request, response);
			
			
			session.getTransaction().commit();
			System.out.println("commit");
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("rollback");
			e.printStackTrace();
		}finally {
			System.out.println("Session back to Connet pool");
		}
		
	}


}
