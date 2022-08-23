package tw.hibernateDemo.service;

import java.util.List;

import tw.hibernateDemo.model.CompanyBean;

public interface CompanyServiceInterface {
	public CompanyBean select(Integer id);
	public List<CompanyBean> selectAll();
	public CompanyBean insert(CompanyBean companyBean);
	public CompanyBean updateOne(Integer id , String comName );
	public boolean deleteOne(Integer id);
}
