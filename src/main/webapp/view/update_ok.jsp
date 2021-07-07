<%@page import="com.ict.db.VO"%>
<%@page import="com.ict.db.DAO"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	VO vo = new VO();
	vo.setIdx(request.getParameter("idx"));
	vo.setName(request.getParameter("name"));
	vo.setTitle(request.getParameter("title"));
	vo.setEmail(request.getParameter("email"));
	vo.setContent(request.getParameter("content"));
	vo.setPw(request.getParameter("pw"));

	WebApplicationContext context = 
			WebApplicationContextUtils.getWebApplicationContext(application);

	DAO dao = (DAO) context.getBean("dao");

	int result = dao.getUpdate(vo);
	if (result > 0) {
		response.sendRedirect("list.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>