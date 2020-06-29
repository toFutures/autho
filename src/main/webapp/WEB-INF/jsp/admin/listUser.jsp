<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/26
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@include file="head.jsp"%>
<br>
<div class="content" style="position: relative;left:25px;right: 10px;">
    <li><a href="<%=basePath%>/addUser">添加用户</a></li>
    <table border="1px">
        <thead>
        <tr>
            <td>用户id</td>
            <td>用户名</td>
            <td>用户密码</td>
            <td>盐</td>
            <td>角色id</td>
            <td>是否锁定</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getSalt()}</td>
                <td>${user.getRoleId()}</td>
                <td>${user.getLocked()}</td>
                <td>
                    <a href="<%=basePath%>/updateUser?id=${user.getId()}">修改</a>
                    <a href="<%=basePath%>/user/deleteUser?id=${user.getId()}">删除</a>
                    <input type="button" onclick="javascript:deleteUser(${user.getId()})" value="删除"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    function deleteUser(id) {
        if (confirm("确认删除？") === true) {
            $.get(
                "<%=basePath%>/user/deleteUser",
                "id=" + id,
                function (data) {
                    if (data.code === 1000) {
                        alert("已删除" + data.data + "记录");
                    } else {
                        alert("删除失败");
                    }
                }
            )
        } else {
            return;
        }
    }
</script>
<%@include file="foot.jsp"%>
</body>
</html>
