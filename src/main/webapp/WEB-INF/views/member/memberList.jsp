<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/bootstrap.jsp"></c:import>
<style type="text/css">
	.c1 {
		cursor: pointer;
	}
</style>

</head>
<body>

<c:import url="../template/header.jsp"></c:import> 
<div class="container">
  <h3>Member List Page</h3>
  <div class="row">
  <div class="col-sm-8">
  <form action="./memberList" id="searchForm">
  <input type="hidden" name="curPage" id="curPage">
       <div class="input-group">
       		<select class="input-group-sm" id="sel1" name="kind">
       			<option value="id">Id</option>
       			<option value="name">Name</option>
       			<option value="eamil">Email</option>
       		</select>
       		
	        <input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
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
  		<span class="c1" title="${pager.startNum-1}" >[이전]</span>
  	</c:if>
  
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<span class="c1" title="${i}">${i}</span>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  		<span class="c1" title="${pager.lastNum+1}">[다음]</span>
  	</c:if>
 </div>
	
	
 <a href="./memberJoin" class="btn btn-danger">Join</a>
 
</div>
<script type="text/javascript">
	var kind = '${pager.kind}';
	var search = '${pager.search}';
	if(kind == ''){
		kind='id';
	}
	$("#kind").val(kind);
	$("#search").val(search);
	
	$(".c1").click(function() {
		var c = $(this).attr("title");
		$("#curPage").val(c);
		$("#kind").val(kind);
		$("#search").val(search);
		$("#searchForm").submit();
	});
</script>



</body>
</html>