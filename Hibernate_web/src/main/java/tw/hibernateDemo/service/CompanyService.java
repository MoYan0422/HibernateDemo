package tw.hibernateDemo.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernateDemo.model.CompanyBean;
import tw.hibernateDemo.model.CompanyDao;

public class CompanyService implements CompanyServiceInterface {
	
	private CompanyDao companyDao;
	
	public CompanyService(Session session) {
		this.companyDao = new CompanyDao(session);
	}

	@Override
	public CompanyBean select(Integer id) {

		CompanyBean theCom = companyDao.select(id);
		return theCom;
	}

	@Override
	public List<CompanyBean> selectAll() {
		List<CompanyBean> companyBeans = companyDao.selectAll();
		return companyBeans;
	}

	@Override
	public CompanyBean insert(CompanyBean companyBean) {
		 CompanyBean theCom = companyDao.insert(companyBean);
		 return theCom;
	}

	@Override
	public CompanyBean updateOne(Integer id, String comName) {
		CompanyBean theCom = companyDao.updateOne(id, comName);
		return theCom;
	}

	@Override
	public boolean deleteOne(Integer id) {
		
		return companyDao.deleteOne(id);
	}

}
