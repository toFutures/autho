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
    <title>添加用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-3.3.1.min.js"></script>
</head>
<body>
<form>
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password" name="password"></td>
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
        var username=$("#username").val();
        var password=$("#password").val();
        $.ajax({
            url: "<%=basePath%>/user/addUser",
            type: "post",
            data: {"username":username,"password":password},
            dataType: "json",
            success: function (data) {
                if (data.code === 1000) {
                    window.location.href="http://localhost:8080/autho/listUser";
                } else {
                    window.location.href="http://localhost:8080/autho/404";
                }
            }
        })
    }
</script>
</body>
</html>
