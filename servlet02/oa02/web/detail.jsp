<%@ page import="com.powernode.oa.obj.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>部门详情</title>
</head>
<body>
  <h1>部门详情</h1>
  <%
      Dept deptDetail = (Dept)request.getAttribute("dept");
      String deptno = deptDetail.getDeptno();
      String dname = deptDetail.getDname();
      String loc = deptDetail.getLoc();
  %>
    <hr >
    部门编号: <%=deptno%> <br>
    部门名称: <%=dname%> <br>
    部门位置: <%=loc%> <br>
    <input type='button' value='返回' onclick='window.history.back()'/>
</body>
</html>