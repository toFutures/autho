<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>/static/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-3.3.1.min.js"></script>
    <title>首页</title>
</head>
<body>
<h2 class="text-center">lsdd blog</h2>
<hr/>
<form class="form-inline text-center">
    <label>username:</label>
    <input type="text" class="form-control" name="username"/>
    <br/>
    <br/>
    <label>password:</label>
    <input type="password" class="form-control" name="password"/>
    <br/>
    <br/>
    <br/>
    <br/>
    <a href="<%=basePath%>/user/regist" class="btn btn-default">注册</a>

    <input type="button" onclick="javascript:login()" value="登录" class="btn btn-default"/>

</form>

<script type="text/javascript">
    function login() {
        $.ajax({
            url: "<%=basePath%>/user/login.do",
            type: "post",
            data: $("form").serialize(),
            dataType: "json",
            success: function (data) {
                if (data.code === 1000) {
                    window.location = "http://localhost:8080/autho/menu";
                }else{
                    window.location = "http://localhost:8080/autho/404";
                }
            }
        })
    }
</script>
</body>
</html>
