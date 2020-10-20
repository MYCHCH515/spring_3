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
  <h2>Notice Update Form</h2>
  <form action="./memberUpdate" method="post">
    <input type="hidden" name="num" value="${dto.num}">
    
     <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" readonly="readonly" id="id" placeholder="Enter id" name="id" value="${dto.id}">
    </div>
    
     <div class="form-group">
      <label for="pw">Pw:</label>
      <input type="text" class="form-control" id="pw" placeholder="Enter pw" name="pw" value="${dto.pw}">
    </div>
    
     <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" readonly="readonly" id="name" placeholder="Enter name" name="name" value="${dto.name}">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${dto.email}">
    </div>
 
    <button type="submit" class="btn btn-default">Update</button>
  </form>
</div>


</body>
</html>