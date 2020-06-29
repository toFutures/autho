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
    <title>修改角色</title>
</head>
<body>
<form action="<%=basePath%>/role/updateRolePer" method="post">
    <table border="1px">
        <tr>
            <td>角色id：</td>
            <td><input type="text"  name="id" value="${rolePerVO.getId()}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>角色名：</td>
            <td><input type="text"  name="role" value="${rolePerVO.getRole()}"></td>
        </tr>
        <tr>
            <td>角色描述：</td>
            <td>
                <input type="text"  name="description" value="${rolePerVO.getDescription()}">
            </td>
        </tr>
        <tr>
            <td>资源编辑</td>
            <td>
                <c:forEach items="${rolePerVO.getPermissionSet()}" var="per">
                    <label><input name="perId" type="checkbox" value="${per.getId()}" checked/>${per.getPermission()}</label><br>
                </c:forEach>
                <c:forEach items="${permissionList}" var="per">
                    <label><input name="perId" type="checkbox" value="${per.getId()}"/>${per.getPermission()}</label><br>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>是否锁定</td>
            <td>
                <input type="radio" name="available"
                <c:if test="${rolePerVO.getAvailable()}">
                        checked="checked"
                </c:if>>
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
