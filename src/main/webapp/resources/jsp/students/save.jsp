<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/students/saveStudents" method="post">
    <p>学号：<input type="text" name="xh"  /></p>
    <p>姓名：<input type="text" name="name"  /></p>
    <p>性别：
        <select name="sex" id="sex">
            <option value="男">男</option>
            <option value="女">女</option>
            <option value="其它">其它</option>
        </select>
    </p>
    <p>年龄：<input type="text" name="age" /></p>
    <p>班级：
        <select name="gid" id="gid">
            <c:forEach items="${gradesPageInfo.list}" var="grade">
                <option value="${grade.gid}">${grade.gname}</option>
            </c:forEach>
        </select>
    </p>
    <p>生日：<input type="date" name="birthday"/></p>
    <p>地址：<input type="text" name="address" /></p>
    <p>状态：<input type="text" name="state" value="0" /></p>
    <p><input type="submit" value="添加" /></p>
</form>
</body>
</html>
