package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class ListCommand implements Command{
		@Override
		public String exec(HttpServletRequest request, HttpServletResponse response) {
			
			Paging pvo = new Paging();
			
			// 1. 전체 게시물의 수를 구한다.
			int count = DAO.getCount();
			pvo.setTotalRecord(count);
			
			// 2. 전체 게시물의 수를 활용해서 전체 페이지의 수를 구하자
			pvo.setTotalPage(pvo.getTotalRecord()/pvo.getNumPerPage());
			
			// 나눠서 0이 아니면(나머지가 존재하면) 전체 페이지에서 한(1)페이지 더 증가
			if(pvo.getTotalRecord()%pvo.getNumPerPage()!=0) {
				pvo.setTotalPage(pvo.getTotalPage()+1);
			}
			
			// 3. 현재 페이지 구하기(ListCommand)
			// 무조건 ListCommand는 cPage 라는 파라미터를 넣어야 한다.
			// cmd가 list이면 무조건 cPage 파라미터를 넣어야 한다.
			String cPage = request.getParameter("cPage");
			pvo.setNowPage(Integer.parseInt(cPage));
			
			// ** 4. 현재 시작번호와 끝번호를 구해서 DB 정보 가져오기
			pvo.setBegin((pvo.getNowPage()-1)*pvo.getNumPerPage()+1);
			pvo.setEnd((pvo.getBegin()-1)+pvo.getNumPerPage());
			List<BVO> list = DAO.getList(pvo.getBegin(), pvo.getEnd());
			
			
			
			// ** 5. 시작블록과 끝블록 구하기
			pvo.setBeginBlock((int)(pvo.getNowPage()-1)/pvo.getPagePerBlock()*pvo.getPagePerBlock()+1);
			pvo.setEndBlock(pvo.getBegin()+pvo.getPagePerBlock()-1);
			
			// 주의사항 : endBlock이 totalPage보다 클수가 있다.
			if(pvo.getEndBlock() > pvo.getTotalPage()) {
				pvo.setEndBlock(pvo.getTotalPage());
			}
			
			
			request.setAttribute("list", list);
			request.getSession().setAttribute("pvo", pvo);
			return "view/list.jsp";
		}

}






























