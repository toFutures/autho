<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/26
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>菜单</title>
</head>
<body>
<%@include file="head.jsp"%>
<br>
    <div style="position: absolute;top: 30%;left:40%;">
        <ul>
            <li><a href="<%=basePath%>/listUser">用户列表</a></li>
            <li><a href="<%=basePath%>/listRole">角色管理</a> </li>
            <li><a href="<%=basePath%>/listPermission">权限管理</a> </li>
            <li><a href="<%=basePath%>/userrolelist">用户角色管理</a> </li>
            <li><a href="<%=basePath%>/roleperlist">角色资源管理</a> </li>
        </ul>
    </div>
</body>
<%@include file="foot.jsp"%>
</html>
