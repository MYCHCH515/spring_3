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
  <h2>Member Join Form</h2>
  <form action="./memberJoin" method="post">
    
    <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
     <div class="form-group">
      <label for="pw">Pw:</label>
      <input type="text" class="form-control" id="pw" placeholder="Enter pw" name="pw">
    </div>
  
  	 <div class="form-group">
      <label for="writer">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
  
  	 <div class="form-group">
      <label for="writer">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
  
    <button type="submit" class="btn btn-default">Join</button>
  </form>
</div>

</body>
</html>