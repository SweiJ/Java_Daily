<%@ page import="java.util.List" %>
<%@ page import="com.powernode.oa.obj.Dept" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>部门列表页面</title>
</head>
    <body>
        <script type="text/javascript">
            function del(dno) {
                // 显示提示框
                if(window.confirm('亲,删除了就不能恢复了!')) {
                    document.location.href = '<%=request.getContextPath()%>/dept/delete?deptno=' + dno;
                }
            }
        </script>

        <h1 align='center'>部门列表</h1>
        <hr >
        <table border='1px' align='center' width='50%'>
            <tr>
                <th>序号:</th>
                <th>部门编号:</th>
                <th>部门名称:</th>
                <th>部门位置:</th>
                <th>操作</th>
            </tr>

            <%
                List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
                int i = 0;
                for (Dept dept : deptList) {
                    String deptno = dept.getDeptno();
                    String dname = dept.getDname();
                    String loc = dept.getLoc();
            %>
            <tr>
                <td><%=++i%></td>
                <td><%=deptno%></td>
                <td><%=dname%></td>
                <td><%=loc%></td>
                <td>
                    <a href='javascript:void(0)' onclick="del(<%=deptno%>)">删除</a>
                    <a href='<%=request.getContextPath()%>/dept/detail?f=edit&deptno=<%=deptno%>'>修改</a>
                    <a href='<%=request.getContextPath()%>/dept/detail?f=detail&deptno=<%=deptno%>'>详情</a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
        <hr >
        <a href='<%=request.getContextPath()%>/add.jsp'>新增部门</a>

    </body>
</html>