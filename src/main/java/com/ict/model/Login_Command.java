package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.UVO;

public class Login_Command implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		UVO uvo = DAO.getLogin(new UVO(id, pwd));
		
		if(uvo != null) {
			request.getSession().setAttribute("uvo", uvo);
			System.out.println("uvo o"+uvo.toString());
			return "MyController?cmd=list&cPage=1";
		}
		
			return "MyController?cmd=index";
		
	}
}
