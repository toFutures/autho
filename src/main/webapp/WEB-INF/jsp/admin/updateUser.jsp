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
<form action="<%=basePath%>/user/updateUser" method="post">
    <table border="1px">
        <tr>
            <td>id：</td>
            <td><input type="text" name="id" value="${user.getId()}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${user.getUsername()}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password" value="${user.getPassword()}">
            </td>
        </tr>
        <tr>
            <td>盐</td>
            <td>
                <input type="text" name="salt" value="${user.getSalt()}">
            </td>
        </tr>
        <tr>
            <td>角色id</td>
            <td>
                <input type="text" name="roleId" value="${user.getRoleId()}">
            </td>
        </tr>
        <tr>
            <td>是否锁定</td>
            <td>
                <input type="radio" name="locked"
                <c:if test="${user.getLocked()}">
                       checked="checked"
                </c:if>
                >
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
