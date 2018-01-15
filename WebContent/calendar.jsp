<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usebean</title>
</head>
<body>
<jsp:useBean id="datebean" class="com.kame.test.CanlendarFace"/>
<%
	String year,month,date;
	year = request.getParameter("year");
	month = request.getParameter("month");
	date = request.getParameter("date");
	out.println(datebean.showHtml(year,month,date));
%>
</body>
</html>