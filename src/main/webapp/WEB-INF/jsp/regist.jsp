<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/14
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>lsdd-用户注册</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/css/bootstrap-theme.css">
    <script rel="script" href="<%=basePath%>/static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //简单的实现用户名和密码重置的功能
        function czmima(){
            document.getElementById("inputName").value="";
            document.getElementById("inputPassword").value="";
            document.getElementById("inputPassword1").value="";
        }

        //校验数据
        function checkUserName() {
            var userName=document.getElementById("inputName").value;
            //创建XMLHttpRequest对象
            var xmlHttp=null;
            if(window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }else{
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //XMLHttpRequest对象请求后台服务
            xmlHttp.onreadystatechange=function(){
                if(xmlHttp.readyState==4&&xmlHttp.status==200){
                    var dataObject = eval("("+xmlHttp.responseText+")");
                    if(dataObject.exist){
                        //如果用户名存在，就会在文本框的后边显示一个X的图标，表示这个用户名称不可用
                        document.getElementById("img").innerHTML="<img src='no.png'/>&nbsp;该用户名称已经存在！";
                    }else{
                        //如果用户名存在，就会在文本框的后边显示一个“对号”的图标，表示这个用户名称可用
                        document.getElementById("img").innerHTML="<img src='ok.png'/>&nbsp;该用户名称可以使用！";
                    }
                }
            }
            //规定请求类型、请求处理的地址以及是否使用异步请求处理。
            //这里还需要把用户输入的用户名作为参数传给后台servlet用以判断
            xmlHttp.open("get","checkUserNameServlet?userName="+userName,true);
            //将请求发送给服务器进行处理
            xmlHttp.send();
        }
    </script>
</head>
<body style="background-image: url(<%=basePath%>/static/img/bodyground.png);background-size: 100%">
<div class="bs-tooltip-auto">
    <a></a>
    <br/>
    <br/>
</div>
<div class="container col-lg-4">
    <div class="form-group">
        <form id="addUserForm" action="#" method="post">
            <h2 class="form-group text-center">用户注册</h2>
            <label for="inputName" class="sr-only">userName</label>
            <input type="text" id="inputName" class="form-control" placeholder="用户名" required autofocus>
            <br/>
            <label for="inputSex" class="sr-only">Sex</label>
            <input type="text" id="inputSex" class="form-control" placeholder="性别" required autofocus>
            <br/>
            <label for="inputPhone" class="sr-only">Phone</label>
            <input type="text" id="inputPhone" class="form-control" placeholder="电话" required autofocus>
            <br/>
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="text" id="inputEmail" class="form-control" placeholder="邮箱" required autofocus>
            <br/>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required autofocus>
            <br/>
            <input type="password" id="rePassword" class="form-control" placeholder="请再次输入密码" required autofocus>
            <br/>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> 记住密码
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="button" onclick="javascript:regist();">注册</button>
            <a id="regist" class="btn btn-lg btn-primary btn-block" onclick="javascript:regist();">注册</a>
        </form>
    </div>
</div>

<script src="<%=basePath%>/static/js/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>/static/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/static/js/bootstrapValidator.min.js"></script>
<script src="<%=basePath%>/static/js/form.js"></script>

<script>
    function regist() {
        var password=$('#inputPassword').val();
        var repassword=$('#rePassword').val();
        if(password!=repassword){
            alert("两次密码输入不一致！");
        }
    }

</script>

</body>
</html>
