<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>

<title>分页案列</title>

</head>

<body>
	<table>
		<tr>
			<td>编码</td>
			<td>姓名</td>
		</tr>
		<c:forEach items="${sessionScope.list}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="getAll?pageindex=1">首页</a>
	<a href="getAll?pageindex=${pageindex-1}">上一页</a>
	<form action="getAll" method="post">
		<input type="text" size="2" name="pageindex" /> 
		<input type="submit" value="查找" />
	</form>
	<a href="getAll?pageindex=${pageindex+1}">下一页</a>
	<a href="getAll?pageindex=${countpage}">末页</a>
</body>
</html>
