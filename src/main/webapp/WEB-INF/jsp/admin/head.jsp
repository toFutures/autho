<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZM
  Date: 2020/6/26
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-header" style="position: relative;left:25px;right: 10px;">
    <c:if test="${loginUser!= null}">
        欢迎您：<a href="<%=basePath%>/updateUser?id=${loginUser.getId()}">${loginUser.getUsername()}</a>
        <label style="position: relative;right: 0%"><a href="<%=basePath%>/doLogout">退出</a> </label>
    </c:if>
    <c:if test="${loginUser== null}">
        <a href="/autho/">请登录</a>
    </c:if>
</div>