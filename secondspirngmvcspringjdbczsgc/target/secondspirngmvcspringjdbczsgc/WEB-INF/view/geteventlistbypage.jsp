<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="assets/css/css1.css" rel="stylesheet" type="text/css"/>

</head>

<body>

<div class="container">
	<div class="kh"></div>
	<div class="zw">
		测试列表
		<div class="kh"></div>
		
		<div class="liebiao">
			<c:forEach var="item" items="${list}">
				${item.title}<br/>
			</c:forEach>
		</div>
	<div class="kh"></div>
		总数${count}
		共${pages}页
		请求传来的页数${spage}<br/>
	<c:if test="${pages > 1}">
		<c:forEach var="i" begin="1" end="${pages}" step="1">   
			<a href="geteventlistbypage?page=<c:out value="${i}"/>"><c:out value="${i}" /></a>
		</c:forEach>
	</c:if>	
		
	</div>
</div>
</body>

</html>