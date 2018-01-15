<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>event edit</title>
</head>
<body>
<%@ page import="com.kame.admin.EventSelect" %>
<%@ page import="java.util.List" %>
<jsp:useBean id="event" class="com.kame.admin.EventSelect"/>
<%
	String year,month,date;
	year = request.getParameter("year");
	month = request.getParameter("month");
	date = request.getParameter("date");
	EventSelect eventse = new EventSelect();
	List eventinfo = eventse.getSingleEventList(year+"-"+month+"-"+date);
%>
<h2>	event sign up</h2>
<form method="post" action ="EventEdit">
name:<input type="text" name="name" value="<%out.println(eventinfo.get(0));%>"></br>
eventdate:<input type="text" name="eventdate" readonly="true" value="	<%out.println(year+"-"+month+"-"+date);%>"></br>
info:</br><textarea name="info" rows="10" cols="20"><%out.println(eventinfo.get(1));%></textarea></br>
<input type="hidden" name="id" value="<%out.println(eventinfo.get(2));%>"></br>
<input type="submit" value="go" name="process">
<input type="reset" value="cancel" name="process">
</body>
</html>