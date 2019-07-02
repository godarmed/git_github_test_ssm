<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>展示所有员工</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="<c:url value='/resources/css/amazeui.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/resources/css/amazeui.datatables.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/resources/css/app.css'/>">
    <script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
</head>
<body>
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf am-u-sm-centered">
                <div class="widget-head am-cf am-u-sm-centered">
                    <div class="widget-title  am-cf">学生列表</div>
                </div>

                <!--条件查询-->
                <div class="am-u-sm-10 am-u-sm-centered">
                    <form id="myForm" action="<c:url value='/students/selectStudents'/>" method="post" >
                        姓名：<input type="text"  class="am-redius" name="name" value="${params.name}" size="6"/>
                        班级:
                        <select name="gid" id="gid">
                            <option value="">全部年级</option>
                            <c:forEach items="${gradesPageInfo.list}" var="grade">
                                <option value="${grade.gid}" ${params.gid == grade.gid?'selected':''}>${grade.gname}</option>
                            </c:forEach>
                        </select>
                        地址：<input type="text"  class="am-redius" name="address" value="${params.address}" size="6"/>
                        生日：<input type="date"  class="am-redius" name="birthdayFrom" value="<fmt:formatDate value="${params.birthdayFrom}" pattern="yyyy-MM-dd" />" size="6"/>
                        -<input type="date"  class="am-redius" name="birthdayTo" value="<fmt:formatDate value="${params.birthdayTo}" pattern="yyyy-MM-dd" />" size="6"/>
                        <input id="pn" type="hidden" name="pageNum" value="${params.pageNum}" />
                        <input id="ps" type="hidden" name="pageSize" value="${params.pageSize}" />
                        <input id="ob" type="hidden" name="orderBy" value="${params.orderBy}" />
                        <input type="submit" class="am-btn am-btn-primary am-btn-sm" value="搜索" />
                        <a href="<c:url value='/students/savePageStudents'/>" class="am-btn am-btn-success am-btn-sm"><span class="am-icon-plus"></span>添加</a>
                        <a href="javascript:deleteMore()" class="am-btn am-btn-success am-btn-sm"><span class="am-icon-subscript"></span>删除</a>
                    </form>
                </div>

                <div class="am-u-sm-12 am-u-sm-centered" style="text-align:center">
                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black" id="example-r">
                    <thead>
                        <tr class=".am-primary .am-text-center">
                            <th class="table-check">
                                <input id="checkAll" type="checkbox">
                            </th>
                            <th><a href="javascript:orderBy('xh')" class="am-badge am-badge-secondary am-redius am-text-default">学号</a></th>
                            <th><a href="javascript:orderBy('name')" class="am-badge am-badge-secondary am-redius am-text-default">姓名</a></th>
                            <th><a href="javascript:orderBy('sex')" class="am-badge am-badge-secondary am-redius am-text-default">性别</a></th>
                            <th><a href="javascript:orderBy('age')" class="am-badge am-badge-secondary am-redius am-text-default">年龄</a></th>
                            <th><a href="javascript:orderBy('birthday')" class="am-badge am-badge-secondary am-redius am-text-default">生日</a></th>
                            <th><a href="javascript:orderBy('address')" class="am-badge am-badge-secondary am-redius am-text-default">地址</a></th>
                            <th><a href="javascript:orderBy('gid')" class="am-badge am-badge-secondary am-redius am-text-default">班级</a></th>
                            <th><a href="javascript:orderBy('state')" class="am-badge am-badge-secondary am-redius am-text-default">状态</a></th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${studentsPageInfo.list}" var="student" >
                            <tr class=".am-text-center">
                                <td><input class="check" type="checkbox"></td>
                                <td>${student.xh}</td>
                                <td>${student.name}</td>
                                <td>${student.sex}</td>
                                <td>${student.age}</td>
                                <td>
                                    <fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd" />
                                </td>
                                <td>${student.address}</td>
                                <td>${student.grade.gname}</td>
                                <td>${student.state}</td>
                                <td>
                                    <div class="tpl-table-black-operation">
                                        <a href="${pageContext.request.contextPath}/students/updatePageStudents/${student.xh}">
                                            <i class="am-icon-pencil"></i> 修改
                                        </a>
                                        <a href="${pageContext.request.contextPath}/students/deleteStudentsById/${student.xh}">
                                            <i class="am-icon-trash"></i> 删除
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
                <!--分页-->
                <div class="am-u-sm-8 am-u-sm-centered" style="text-align:center">
                    <a class="am-btn am-btn-warning am-btn-sm am-redius" href="javascript:toPage(1);">首页</a>
                    <a class="am-btn am-btn-warning am-btn-sm am-redius" href="javascript:toPage(${studentsPageInfo.pageNum-1});">上一页</a>
                    <a class="am-btn am-btn-warning am-btn-sm am-redius" href="javascript:toPage(${studentsPageInfo.pageNum+1});">下一页</a>
                    <a class="am-btn am-btn-warning am-btn-sm am-redius" href="javascript:toPage(${studentsPageInfo.pages});">尾页</a>

                    <select id="pageSize" onchange="toPage(1)">
                        <option value="2"  <c:if test="${studentsPageInfo.pageSize==2}">selected</c:if> >2</option>
                        <option value="4"  <c:if test="${studentsPageInfo.pageSize==4}">selected</c:if>  >4</option>
                        <option value="6"  <c:if test="${studentsPageInfo.pageSize==6}">selected</c:if>  >6</option>
                        <option value="8"  <c:if test="${studentsPageInfo.pageSize==8}">selected</c:if>  >8</option>
                        <option value="10" <c:if test="${studentsPageInfo.pageSize==10}">selected</c:if> >10</option>
                    </select>
                    第${studentsPageInfo.pageNum}页/共${studentsPageInfo.pages}页
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    function toPage(pageNum) {
        //获取每天显示的条数
        var ps = $("#pageSize").val();
        //给pageSize设值
        $("#ps").val(ps);
        //给pageNum设值
        $("#pn").val(pageNum);
        //提交表单
        $("#myForm").submit();
    }

    function orderBy(column) {
        //给orderBy设值
        if($("#ob").val().trim() == ''){
            $("#ob").val(column + ' ASC');
        }else if($("#ob").val().indexOf('ASC') == -1 ){
            $("#ob").val(column + ' ASC');
        }else{
            $("#ob").val(column + ' DESC');
        }
        //提交表单
        $("#myForm").submit();
    }

    function deleteMore(){
        //获取获取所有的单选框
        var deleteXhs = {}
        //便历并返回相应的值
        $("#example-r .check:checked").each(function(i,e){
            deleteXhs[i] = $(e).parent().next().html();
        });

        deleteXhs = JSON.stringify(deleteXhs);//把对象转换成json

        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/students/deleteMoreStudents',
            data: deleteXhs,
            contentType : "application/json;charsetset=UTF-8",//必须
            dataType: 'json',
            cache: true,
            async: false,
            success: function(data) {
                if(data!=""){
                    //提交表单
                    $("#myForm").submit();
                }
            }
        })
    }
</script>
</html>
