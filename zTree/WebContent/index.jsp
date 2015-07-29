<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>zTree test</title>
  </head>
  
  <body>
   	<button onclick="javascript:window.location.href='simpleData.jsp'">简单数据</button>
   	<br/>
    <br/>
   	<button onclick="javascript:window.location.href='ajaxGetData.jsp'">ajax获取数据</button>
   	<br/>
    <br/>
   	<button onclick="javascript:window.location.href='asyncGetData.jsp'">异步加载数据</button>
  </body>
</html>








