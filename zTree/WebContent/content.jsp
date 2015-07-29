<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<div style="text-align:center;font-size:24px;color:red">
		<span>异步加载数据内容显示区</span>
	</div>
	<div style="text-align:center;font-size:20px;">
		<span>中有单点击节点为叶子节点时，内容区域方才发生变化</span> <br/>
		<span>你点击的节点是:
		<% 
			String name = request.getParameter("name");
			if(name != null) {
				name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
				out.println(name);
			}
		%>
		</span>
	</div>
</body>
</html>