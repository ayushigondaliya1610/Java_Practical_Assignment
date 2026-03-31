<%-- 
    Document   : addCategory
    Created on : 03-Feb-2026, 11:53:21 am
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CategoryServlet" method="post">
  Category Name: <input type="text" name="category_name">
  <input type="submit" value="Add Category">
</form>

    </body>
</html>
