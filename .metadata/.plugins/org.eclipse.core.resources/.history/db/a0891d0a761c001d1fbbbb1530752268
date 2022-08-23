package tw.hibernateDemo.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class CompanyDao implements CompanyDAOinterface {
	private Session session;
	
	public CompanyDao(Session session) {
		this.session = session;
	}
	
	@Override
	public CompanyBean insert(CompanyBean comBean) {
		CompanyBean companyBean = session.get(CompanyBean.class,comBean.getCompanyID());
		if(companyBean == null ) {
			session.save(comBean);
			return comBean;
		}
		return null;
	}

	@Override
	public CompanyBean select(int id) {
		// TODO Auto-generated method stub
		CompanyBean companyBean = session.get(CompanyBean.class,id);
		if(companyBean != null ) {
			return companyBean;
		}
		return null;
	}

	@Override
	public List<CompanyBean> selectAll() {
		Query<CompanyBean> query = session.createQuery("from CompanyBean",CompanyBean.class);
		return query.list();
	}

	@Override
	public CompanyBean updateOne(int comId, String comName) {
		CompanyBean companyBean = session.get(CompanyBean.class,comId);
		if(companyBean != null ) {
			companyBean.setCompanyName(comName);
			return companyBean;
		}
		return null;
	}

	@Override
	public boolean deleteOne(int comId) {
		// TODO Auto-generated method stub
		CompanyBean companyBean = session.get(CompanyBean.class,comId);
		if(companyBean != null ) {
			session.delete(companyBean);
			return true;
		}
		return false;
	}

}
