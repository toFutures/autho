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
    <title>角色列表</title>
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@include file="../head.jsp"%>
<br>
<div class="content" style="position: relative;left:25px;right: 10px;">
    <li><a href="<%=basePath%>/addRole">添加角色</a></li>
    <table border="1px">
        <thead>
        <tr>
            <td>角色id</td>
            <td>角色名</td>
            <td>角色描述</td>
            <td>父角色</td>
            <td>是否锁定</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roleList}" var="role">
            <tr>
                <td>${role.getId()}</td>
                <td>${role.getRole()}</td>
                <td>${role.getDescription()}</td>
                <td>${role.getpRole().getRole()}</td>
                <td>${role.getAvailable()}</td>
                <td>
                    <a href="<%=basePath%>/updateRole?id=${role.getId()}">修改</a>
                    <a href="<%=basePath%>/role/deleteRole?id=${role.getId()}">删除</a>
                    <input type="button" onclick="javascript:deleteRole(${role.getId()})" value="删除"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    function deleteRole(id) {
        if (confirm("确认删除？") === true) {
            $.get(
                "<%=basePath%>/role/deleteRole",
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
<%@include file="../foot.jsp"%>
</body>
</html>
