<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/26
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>添加角色</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-3.3.1.min.js"></script>
</head>
<body>
<form>
    <table>
        <tr>
            <td>角色名：</td>
            <td><input type="text" id="role" name="role"></td>
        </tr>
        <tr>
            <td>角色描述：</td>
            <td><input type="text" id="description" name="description"></td>
        </tr>
        <tr>
            <td>父角色：</td>
            <td>
                <select name="pid">
                    <option value =""></option>
                    <c:forEach items="${roleList}" var="role">
                        <option value ="${role.getId()}">${role.getRole()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>是否锁定：</td>
            <td>
                <input type="radio" id="available" name="available">
            </td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="button" onclick="javascript:addUser()" value="添加"></td>
        </tr>
    </table>
</form>
<div id="msg"></div>
<script>
    function addUser() {
        $.ajax({
            url: "<%=basePath%>/role/addRole",
            type: "post",
            data: $("form").serialize(),
            dataType: "json",
            success: function (data) {
                if (data.code === 1000) {
                    window.location.href="http://localhost:8080/autho/listRole";
                } else {
                    window.location.href="http://localhost:8080/autho/404";
                }
            }
        })
    }
</script>
</body>
</html>
