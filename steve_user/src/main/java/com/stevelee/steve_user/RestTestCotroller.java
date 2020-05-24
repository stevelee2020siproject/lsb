package com.stevelee.steve_user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestCotroller {

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/useralllist")
	public JSONArray RestTest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("asdf");
		//String mail_id = "jjj@naver.com";
		
		 List<Map<String, Object>> userlist;
		 
		 userlist = sqlSession.selectList("usermapper.useralllist");
		 System.out.println("userlist" + userlist.toString());
		 
		return null;
	}
	
	@RequestMapping("/userselectoneget")
	public String UserSelectOneGet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String mail_id = request.getParameter("mail_id");
		Map<String, Object> userlist = sqlSession.selectOne("usermapper.UserSelectOneGet", mail_id);

		
		return userlist.toString();
	}
	
	@RequestMapping("/userselectonepost")
	public String UserSelectOnePost(HttpServletRequest request, HttpServletResponse response, @RequestBody String posttext) throws Exception {

		String mail_id = posttext;
		Map<String, Object> userlist = sqlSession.selectOne("usermapper.UserSelectOneGet", mail_id);

		
		return userlist.toString();
	}

}
