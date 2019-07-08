<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>考试</title>
    <meta charset="utf-8">
    <style>
    	#main{
    		width: 900px;
    		margin: auto;
    	}
    	#top{
    	 		width: 300px;
    	 		margin: auto;
    	}
    	#head{
    	font-size:36px;
    	}
    </style>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
  </head>	
  <body>
  <c:if test="${!empty requestScope.items}">
  <div>
  	<div id="top">
  	<span class="text-success" id="head">${requestScope.items[0].itemName}考试</span>
  	</div>
	  <div id="main">
		  <form  action="../count" method="post">
		  	<table class="table table-striped">
		  	<thead>
		  		<th>题目</th>
		  		<th>选项A</th>
		  		<th>选项B</th>
		  		<th>选项C</th>
		  	</thead>
		  	<tbody>
		  	<c:forEach items="${requestScope.items}" var="x" varStatus="y">
		  		
		  		<tr>
		  		
		  			<td><span class="text-danger">${x.item}</span></td>
		  			<td><span class="text-primary">${x.achoice}<input type="radio" name="A${y.index}" value="A"></span></td>
		  			<td><span class="text-primary">${x.bchoice}<input type="radio" name="A${y.index}" value="B"></span></td>
		  			<td><span class="text-primary">${x.cchoice}<input type="radio" name="A${y.index}" value="C"></span></td>
		  			<input type="hidden" value="${x.rightKey}" name="B${y.index}">
		  			
		  		</tr> 	
		  		
		  	</c:forEach>
		  	</tbody>	
		  	</table>
		  	<input type="hidden" value="${sessionScope.x.sid}" name="sid">
		  	<input type="hidden" value="${requestScope.rid}" name="Rid">
		  	<input type="hidden" value="${sessionScope.x.sClass}" name="sClass">
		  	<input type="hidden" value="${requestScope.items[0].itemName}" name="ItemName">
			<input type="submit" value="提交" class="btn btn-danger" onclick="a()">
		  	</form>
	  	</div>
  </div>	
  </c:if>
  </body>
</html>
