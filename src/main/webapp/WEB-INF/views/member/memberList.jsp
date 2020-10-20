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
  <h3>Member List Page</h3>
  <div class="row">
  <div class="col-sm-8">
  <form action="./memberList">
       <div class="input-group">
       		<select class="input-group-sm" id="sel1" name="kind">
       			<option value="id">Id</option>
       			<option value="name">Name</option>
       			<option value="eamil">Email</option>
       		</select>
       		
	        <input id="msg" type="text" class="form-control" name="search" placeholder="Additional Info">
	        <div class="input-group-btn">
	            <button class="btn btn-default" type="submit">
	            <i class="glyphicon glyphicon-search"></i>
	            </button>
	        </div>
      </div> 
  </form>
  </div>
  </div>
 <table class="table table-hover">
	 	<tr>
	 		<td>Num</td>
	 		<td>Id</td>
	 	</tr>
	 <c:forEach items="${lists}" var="dto">
	 	<tr>
		 	<td>${dto.num}</td>
		 	<td><a href="./memberSelect?num=${dto.num}">${dto.id}</a></td>	 	
	 	</tr>
	 </c:forEach>
 </table>
 
 <div>
 	<c:if test="${pager.beforeCheck}">
 	<a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">[이전]</a>
 	</c:if>
 	
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
	</c:forEach> 
	
	<c:if test="${pager.nextCheck}"> <!--true면 현재블럭이 마지막블럭이 아님 -->
	<a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a>
	</c:if>
 </div>
	
	
 <a href="./memberJoin" class="btn btn-danger">Join</a>
 
</div>
</body>
</html>