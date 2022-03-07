<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增部门</title>
</head>
<body>
  <h1>新增部门</h1>
  <hr >
  <form action="<%=request.getContextPath()%>/dept/add" method="post">
      部门编号<input type="text" name="deptno"/><br>
      部门名称<input type="text" name="dname"/><br>
      部门位置<input type="text" name="loc"/><br>
      <input type="submit" name="保存"/><br>
  </form>
</body>
</html>