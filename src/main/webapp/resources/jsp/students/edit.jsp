<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学生修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/students/updateStudents" method="post">
    <input type="hidden" name="xh" value="${students.xh}" />
    <p>姓名：<input type="text" name="name" value="${students.name}" /></p>
    <p>性别：
        <select name="sex" id="sex">
            <option  value="男" ${students.sex eq '男'?'selected':''}>男</option>
            <option  value="女" ${students.sex eq '女'?'selected':''}>女</option>
            <option  value="其它" ${students.sex eq '其它'?'selected':''}>其它</option>
        </select>
    </p>
    <p>年龄：<input type="text" name="age" value="${students.age}" /></p>
    <p>班级：
        <select name="gid" id="gid" >
            <c:forEach items="${grades}" var="grade">
                <option  value="${grade.gid}" ${grade.gid eq students.gid?'selected':''}>${grade.gname}</option>
            </c:forEach>
        </select>
    </p>
    <p>生日：<input type="date" name="birthday" value="<fmt:formatDate value="${students.birthday}" pattern="yyyy-MM-dd" />" /></p>
    <p>地址：<input type="text" name="address" value="${students.address}" /></p>
    <p>状态：<input type="text" name="state" value="${students.state}" /></p>
    <p><input type="submit" value="修改" /></p>
</form>
</body>
</html>
