package com.stevelee.steve_class;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Stevelee_class {

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/classalllist")
	public String Stevlee_classall(HttpServletRequest request, HttpServletResponse response) {

//		List<Map<String, Object>> classlist;
//		classlist = sqlSession.selectList("classmapper.classalllist");
//		System.out.println(classlist);

		String mail_id = request.getParameter("mail_id");
		List<Map<String, Object>> mail_list;

		mail_list = sqlSession.selectList("classmapper.getMailId", mail_id);
		
		System.out.println(mail_list);
		
		return mail_list.toString();
	}
}
