<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎使用OA系统</title>
</head>
<body>
    <h1>LOGIN PAGE</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名: <input type="text" name="username" value=""><br>
    密码:   <input type="password" name="passwd" value=""><br>
           <input type="checkbox" name="f" value="1">十天内免登陆<br>
    <input type="submit" name="login"/><br>
</form>

</body>
</html>