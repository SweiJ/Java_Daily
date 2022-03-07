<%@ page import="com.powernode.oa.obj.Dept" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>修改部门</title>
</head>
<body>
    <h1>修改部门</h1>
    <hr >
    <form action='<%=request.getContextPath()%>/dept/modify' method='post'>
    <%
        Dept dept = (Dept)request.getAttribute("dept");
        String deptno = dept.getDeptno();
        String dname = dept.getDname();
        String loc = dept.getLoc();
    %>
      部门编号<input type='text' name='deptno' value='<%=deptno%>' readonly /><br>
      部门名称<input type='text' name='dname' value='<%=dname%>'/><br>
      部门位置<input type='text' name='loc' value='<%=loc%>'/><br>
      <input type='submit' name='保存'/><br>
    </form>
</body>
</html>