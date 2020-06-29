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
    <title>资源用户</title>
</head>
<body>
<form action="<%=basePath%>/permission/updatePermission" method="post">
    <table border="1px">
        <tr>
            <td>id：</td>
            <td><input type="text"  name="id" value="${permission.getId()}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>资源名：</td>
            <td><input type="text"  name="permission" value="${permission.getPermission()}"></td>
        </tr>
        <tr>
            <td>资源描述</td>
            <td>
                <input type="text"  name="description" value="${permission.getDescription()}">
            </td>
        </tr>
        <tr>
            <td>父资源</td>
            <td>
                <select name="rid">
                    <c:if test="${permission.getRid() !=null}">
                        <option value ="${permission.getRid()}">${permission.getRid()} </option>
                    </c:if>
                    <option value =""></option>
                    <c:forEach items="${permissionList}" var="permission">
                        <option value ="${permission.getId()}">${permission.getPermission()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>是否锁定</td>
            <td>
                <input type="radio" id="available" name="available"
                <c:if test="${permission.getAvailable()}">
                    checked="checked"
                </c:if>>
            </td>
        </tr>
        <tr>A
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
