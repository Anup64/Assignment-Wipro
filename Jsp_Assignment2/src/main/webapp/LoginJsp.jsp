<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    if (name.equals("Anup") && password.equals("alliswell")) {
        response.sendRedirect("Success.jsp");
    } else {
        response.sendRedirect("FailJsp.jsp");
    }
   %>

</body>
</html>