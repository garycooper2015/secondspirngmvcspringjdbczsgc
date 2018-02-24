<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="maven,jetty,springmvc,springjdbc,onetalbe,add/del/update/list/pagelist">
<title></title>
<link href="assets/css/css1.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">

 <!-- 回车跳转页功能-->
 function jumppage(){
	 var e = window.event || arguments.callee.caller.arguments[0];
	 if(e.keyCode == 13){
		 var number = document.getElementById("page").value;
		 if(isNaN(number)){ /* 如果是真表明不是数字，如果是假表明是数字*/
			 
		 }else{
			 location.href="geteventlistbypage?page=" + number;
		 }
		 
	 }
 }
</script>

<%
 String contextpath = request.getContextPath();
%>

</head>

<body>

<div class="container">
	<div class="kh"></div>
	<div class="zw">
		<div class="pianzuo"><a href="<%=contextpath%>">返回首页</a></div>
		<div class="kh"></div>
		<div class="juzhong">分页列表</div>
		
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
		&nbsp;&nbsp;跳转到<input type="text" value="" id="page" size="4px" onkeydown="jumppage();"/>页
	</c:if>	
		
	</div>
</div>
</body>

</html>