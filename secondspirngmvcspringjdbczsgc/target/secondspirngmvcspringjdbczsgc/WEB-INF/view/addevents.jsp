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
<title>Insert title here</title>

<link href="assets/css/css1.css" rel="stylesheet" type="text/css"/>

</head>




<body>

<div class="container">

	<div class="zw">
		<div class="kh"></div>
		<div class="a1">请添加</div>
		<div class="kh"></div>
		<div class="a2">
			<form action="doaddevents" method="post">
				<div class="a2_1">标题：</div>
				<div class="a2_2"><input type="text" name="title" value=""/>
				<input type="submit" value="提交"/></div>
			</form>
		</div>

	</div>

</div>

</body>

</html>