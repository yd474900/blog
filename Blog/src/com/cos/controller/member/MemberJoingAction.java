package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.action.Action;
import com.cos.dao.MemberDAO;
import com.cos.dto.MemberVO;
import com.cos.util.Script;

public class MemberJoingAction implements Action{
	private static String naming ="MemberJoingAction : ";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
	
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setUsername(request.getParameter("username"));
		member.setEmail(request.getParameter("email"));

		MemberDAO dao =new MemberDAO();
		int result = dao.insert(member);
		
		if(result ==1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			Script.moving(response, "회원가입 완료", url);
		}else if(result == -1) {
			Script.moving(response, "DB 에러!");
		}
	}
}
