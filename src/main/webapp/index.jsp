<%--
  Created by IntelliJ IDEA.
  User: Sergiu
  Date: 18.01.2016
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
  <h1>Hello</h1>
  Enter Name: <input type="text" name="name"/> <br/><br/>
  Enter Password: <input type="password" name="password"/> <br/><br/>
  <input type="submit" value="Login"/>
</form>
</body>
</html>
