<%@page import="com.ch.s3.notice.NoticeDTO"%>
<%@page import="javax.naming.NoInitialContextException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
  
<div class="container">
  <h3>Member SelectPage</h3>
  	<table class="table table-hover">
  	<tr><td>Num:</td><td id="num">${dto.num}</td></tr>
  	<tr><td>Id:</td><td> ${dto.id}</td></tr>
  	<tr><td>Pw:</td><td> ${dto.pw}</td></tr>
  	<tr><td>Name:</td><td> ${dto.name}</td></tr>
  	<tr><td>Email:</td><td> ${dto.email}</td></tr>
  	</table>

 	 <input type="button" value = "Delete" class="btn btn-warning" id="del">
 	 <input type="button" value="Update" class="btn btn-primary" id="upd">
</div>

<script type="text/javascript">
	$("#del").click(function(){
		var num = $("#num").html();
		//alert(num);
		window.location.href="./memberDelete?num="+num;
	});
	
	$("#upd").click(function(){
		window.location.href="./memberUpdate?num=${dto.num}";
	});
</script>

</body>
</html>