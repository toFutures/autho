<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/26
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<form action="<%=basePath%>/user/updateUserRole" method="post">
    <table border="1px">
        <tr>
            <td>id：</td>
            <td><input type="text" name="id" value="${userRoleVO.getId()}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${userRoleVO.getUsername()}"></td>
        </tr>
        <tr>
            <td>角色编辑</td>
            <td>
                <c:forEach items="${userRoleVO.getRoleSet()}" var="role">
                    <label><input name="roleId" type="checkbox" value="${role.getId()}" checked/>${role.getRole()}</label>
                </c:forEach>
                <c:forEach items="${roleList}" var="role">
                    <label><input name="roleId" type="checkbox" value="${role.getId()}"/>${role.getRole()}</label>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            <td>
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
