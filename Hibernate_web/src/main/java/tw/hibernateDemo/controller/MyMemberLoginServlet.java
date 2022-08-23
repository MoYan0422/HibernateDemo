package tw.hibernateDemo.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.hibernateDemo.model.MyMember;
import tw.hibernateDemo.service.MyMemberService;


@WebServlet("/checkLogin")
public class MyMemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyMemberLoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HashMap<String, String> errorMsgMap = new HashMap<String,String>();
		request.setAttribute("errorMsgMap", errorMsgMap);
		HttpSession httpSession = request.getSession();
		String userName = request.getParameter("uname");
		String psw = request.getParameter("psw");
		
		MyMemberService myMemberService = new MyMemberService();
		MyMember result = myMemberService.chackLogin(userName, psw);
		if(result != null) {
			httpSession.setAttribute("loginMember",result);
		}else {
			errorMsgMap.put("LoginError","帳號密碼錯誤，請重新輸入");
		}
		
		
		if(errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("loginOK.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("ligin.jsp");
			rd.forward(request, response);
		}
	}

}
