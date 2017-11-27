<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>

<%@ page import="com.example.guestbook.Greeting" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.example.guestbook.Group" %>
<%@ page import="com.example.guestbook.Student" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>

<body>

<%
	Map<String, Group> groups = new HashMap<String, Group>();
	Group group1 = new Group("1", "Mon 11am - 2pm", "MI", "Michele Dodic");
	Group group2 = new Group("2", "Fri 1am - 3pm", "MI", "Roman Priscepov");
	groups.put(group1.number, group1);
	groups.put(group2.number, group2);

    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
        pageContext.setAttribute("user", user);
        Student student = ObjectifyService.ofy()
				.load()
				.type(Student.class)
				.filter("studentId", user.getEmail())
				.first().now();
        pageContext.setAttribute("student", student);
        
%>

<p>Hello, ${fn:escapeXml(user.nickname)}! (You can
    <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
    
<%
if (student != null && student.registeredGroup != null
		&& groups.get(student.registeredGroup) != null) {
	pageContext.setAttribute("registeredGroup", groups.get(student.registeredGroup));
	
%>

	<h3>You are registered in Group #${registeredGroup.number}</h3>
	<p>Time: ${registeredGroup.time}</p>
	<p>Place: ${registeredGroup.place}</p>
	<p>Instructor: ${registeredGroup.instructor}</p>

<%
} else {		
%>

<form action="/sign" method="post">
<%		
		for (Group group : groups.values()) {
			pageContext.setAttribute("groupNumber", group.number);
%>
<div><input type="radio" name="groupId" value="${groupNumber}"> Group #${groupNumber}</div>
<%
		}
%>
<br />
<div><input type="submit" value="Confirm Group"/></div>
</form>
<%
}    
} else {// USER NOT SIGNED IN
%>
<p>Hello!
    <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
    to the Attendance Tracking System.</p>
<%
    }
%>

<%--
<form action="/sign" method="post">
    <div><textarea name="content" rows="3" cols="60"></textarea></div>
    <div><input type="submit" value="Post Greeting"/></div>
    <input type="hidden" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/>
</form>
--%>
<%-- //[END datastore]--%>
<%-- 
<form action="/guestbook.jsp" method="get">
    <div><input type="text" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/></div>
    <div><input type="submit" value="Switch Guestbook"/></div>
</form>
--%>

</body>
</html>
<%-- //[END all]--%>
