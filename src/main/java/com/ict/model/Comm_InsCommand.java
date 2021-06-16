package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.UVO;

public class Comm_InsCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// b_idx를 얻기 위해서 session에 bvo 호출
		BVO bvo = (BVO)request.getSession().getAttribute("bvo");
		UVO uvo = (UVO)request.getSession().getAttribute("uvo");
		
		CVO cvo = new CVO();
		cvo.setB_idx(bvo.getB_idx());
		cvo.setContent(request.getParameter("content"));
		cvo.setU_idx(uvo.getU_idx());
		
		int result = DAO.getComm_Ins(cvo);
		if(result > 0) {
			return "MyController?cmd=onelist&b_idx="+bvo.getB_idx();
		}
		
		return null;
	}
}
