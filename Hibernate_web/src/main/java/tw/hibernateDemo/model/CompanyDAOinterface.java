package tw.hibernateDemo.model;

import java.util.List;

public interface CompanyDAOinterface {
	public CompanyBean insert(CompanyBean comBean);
	public CompanyBean select(int id);
	public List<CompanyBean> selectAll();
	public CompanyBean updateOne(int comId,String comName);
	public boolean deleteOne(int comId);
}
