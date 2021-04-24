<%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2021/4/17
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("hello jsp");
    int i = 5;

    String contextPath = request.getContextPath();
    out.print(contextPath);
%>

<%!
    int i = 3;
%>
<%= "hello" %>


System.out.println("hello jsp");
<h1>hi~ jsp!</h1>

<% response.getWriter().write("response....."); %>

</body>
</html>
