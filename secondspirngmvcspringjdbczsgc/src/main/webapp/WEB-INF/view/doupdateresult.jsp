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
<link href="assets/css/css1.css" type="text/css" rel="stylesheet"/>
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
		ID为${event_id} 内容为${title} 修改成功！
	</div>
</div>

</body>

</html>