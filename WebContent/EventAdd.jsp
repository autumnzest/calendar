<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>event sign up</title>
</head>
<body>
<%
	String year,month,date;
	year = request.getParameter("year");
	month = request.getParameter("month");
	date = request.getParameter("date");
%>
<h2>	event sign up</h2>
<form method="post" action ="EventAdd">
name:<input type="text" name="name"></br>
eventdate:<input type="text" name="eventdate" readonly="true" value="	<%out.println(year+"-"+month+"-"+date);%>"></br>
info:</br><textarea name="info" rows="10" cols="20"></textarea></br>
<input type="submit" value="go" name="process">
<input type="reset" value="cancel" name="process">
</body>
</html>