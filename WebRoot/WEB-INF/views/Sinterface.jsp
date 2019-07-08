<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>学生界面</title>
    <meta charset="utf-8">  
    <style >
    #main{
    		width: 900px;
    		height:1200px;
    		margin: auto;
    	}
    	#top{
    		width:300px;
    		padding-left:50px;
    		margin: auto;
    	}
    	#form1{
    		display: inline;
    	}
    	 #form2{
    	 display: inline;
    	 }
    	 #not{
    	 font-size:28px;
    	 }
    </style>
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div id="main">
   	<p align="center"> <span class="text-success" id="wecome">欢迎:${sessionScope.x.sClass} ${sessionScope.x.sName}同学<a href="Invalidate">注销</a></span></p>
	   	
	   	<div>
		   	<div id="top">
		   		<form action="slook" method="post" id="form1">
		    		<input type="hidden" name="sid" value="${sessionScope.x.sid}">
		    		<input type="submit" value="查询成绩"  class="btn btn-success">
		    	</form>
		    	<form action="nolook" method="post" id="form2">
		    		<input type="hidden" name="sid" value="${sessionScope.x.sid}">
		    		<input type="hidden" name="sClass" value="${sessionScope.x.sClass}">
		    		<input type="submit" value="查询未考试科目"  class="btn btn-success" >
		    	</form>
		    </div>
	    </div>
	    
	    <div id="score">
	    	<c:if test="${!empty requestScope.studentScore}">
	    	<table class="table table-hover">
    		<thead>
				<th>科目</th>
				<th>成绩</th>
			</thead>
			<tbody>
    		<c:forEach items="${requestScope.studentScore}" var="x">
    			<tr>
    				<td>${x.itemName}</td>
    				<td>${x.score}</td>
    			</tr>
    		</c:forEach>
    		</tbody>
    		</table>  
    		</c:if>  		
	    </div>
	    
	  <c:if test="${!empty requestScope.nottest}">  
	    <div id="look">
	    	<p align="center"> <span class="text-danger" id="not">未考试科目</span></p>
	    	<table class="table table-hover">
	    		<thead>
	    			<th>考场</th>
	    			<th>考试时间</th>
	    			<th>考试科目</th>
	    			<th>考试时长(分钟)</th>
	    		</thead>
	    		<tbody>
	    		<c:forEach items="${requestScope.nottest}" var="x">
	    			<tr>
	    				<td>${x.rid}</td>
	    				<td>${x.time}</td>
	    				<td>${x.exInforation}</td>
	    				<td>${x.duration}</td>
	    				<td><a href="onlineTest/${x.rid}" class="btn btn-info">考试</a></td>
	    			</tr>
	    		</c:forEach>
	    		</tbody>
	    	</table>
	    </div>
	 </c:if>
	 
    </div>
  </body>
</html>
