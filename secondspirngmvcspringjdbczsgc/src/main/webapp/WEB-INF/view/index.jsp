<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String path = request.getContextPath();
//	System.out.println("path = " + path);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<link href="assets/css/css1.css" rel="stylesheet" type="text/css"/>

</head>




<body>

<div class="container">

	<div class="zw">
		<div class="kh"></div>
		<div class="a1">首页</div>
		<div class="kh"></div>
		<div class="liebiao2">
			<a href="addevents">增</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="geteventslistdel">删</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="geteventslistupdate">改</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="searchevents">查</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="geteventslist">列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="geteventlistbypage">分页列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>

	</div>

</div>

</body>