package tw.hibernateDemo.service;

import tw.hibernateDemo.model.MyMember;
import tw.hibernateDemo.model.MyMemberDao;

public class MyMemberService {
	private MyMemberDao myMemberDao;

	public MyMemberService() {
		this.myMemberDao = new MyMemberDao();
	}

	public MyMember chackLogin(String loginUser ,String loginPwd) {
		return myMemberDao.queryUsernameAndPwd(loginUser, loginPwd);
	}

}
