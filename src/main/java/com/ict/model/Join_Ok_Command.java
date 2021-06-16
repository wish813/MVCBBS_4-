package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.UVO;

public class Join_Ok_Command implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	int result = 0;
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	UVO u = new UVO(id, pwd);
	
	result = DAO.getJoin(u);
	if(result>0) {
		return "MyController?cmd=index";		
	}
	return "MyController?cmd=join";
	}
}
