<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>老师界面</title>
    <meta charset="utf-8"> 
    <style>
    	#main{
    		width: 900px;
    		margin: auto;
    	}
    	#center_1{
    		display: none;
    		width: 300px;
    		margin: auto;
    	}
    	#center_2{
    		display: none;
    		width: 300px;
    		margin: auto;
    	}
    	#top{
    		width:300px;
    		padding-left:50px;
    		margin: auto;
    	}
    </style> 
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		function show(id){
		var center_1=document.getElementById("center_1");
		var center_2=document.getElementById("center_2");
		var center_3=document.getElementById("center_3");
		if(id=="plan"){
			center_1.style.display="block";
			center_2.style.display="none";
			center_3.style.display="none";							
		}else if(id=="look"){							
			center_1.style.display="none";
			center_2.style.display="block";
			center_3.style.display="none";
			
		}
		}
	</script>
  </head>
  
  <body>
  <div id="main">
   <p align="center"> <span class="text-success" id="wecome">欢迎:${sessionScope.x.tName}老师<a href="Invalidate">注销</a></span></p>
    
    <div id="top">
    	<button class="btn btn-success" onclick="show('plan')">安排考场</button>
    	<button class="btn btn-success"  onclick="show('look')">查看成绩</button>
    </div>
    
    
    <div id="center_1">
    	<form action="plan" method="post">
    	<span class="text-success">考场</span>
    	<select class="form-control" name="Rid">
    		<option value="301">301</option>
    		<option value="302">302</option>
    		<option value="303">303</option>
    		<option value="304">304</option>
    		<option value="305">305</option>
    		<option value="306">306</option>
    		<option value="307">307</option>
    		<option value="308">308</option>
    	</select>
    	<span class="text-success">考试日期</span><input type="date" name="Time"  class="form-control" ><br>
    	<span class="text-success">考试科目</span>
    	    	<select class="form-control" name="ExInforation">
    		<option value="Java">Java</option>
    		<option value="C++">C++</option>
    		<option value="Android">Android</option>
    		<option value="C#">C#</option>
    		<option value="Python">Python</option>
    	</select>
    	<span class="text-success">考试班级</span>
    	<select class="form-control" name="Eclass">
    		<option value="计应1班">计应1班</option>
    		<option value="计应2班">计应2班</option>
    		<option value="计应3班">计应3班</option>
    		<option value="计应4班">计应4班</option>
    	</select><br>
    	<span class="text-success">考试时间</span><input type="text" name="Duration"  class="form-control" placeholder="考试需要的时间，单位是分钟"><br>
    	<input type="submit" class="btn btn-success" value="确定">
    	</form>
    </div>
    
    
    <div id="center_2">
    	<form method="post" action="look" id="form1">
    	<span class="text-success">需要查询的班级</span>
    	<select class="form-control" name="Class">
    		<option value="计应1班">计应1班</option>
    		<option value="计应2班">计应2班</option>
    		<option value="计应3班">计应3班</option>
    		<option value="计应4班">计应4班</option>
    	</select><br>
    	<span class="text-success">需要查询的课程</span>
    	<select class="form-control" name="Item">
    		<option value="Java">Java</option>
    		<option value="C++">C++</option>
    		<option value="C#">C#</option>
    		<option value="Android">Anrdroid</option>
    		<option value="Python">Python</option>
    	</select><br>
    	<input type="submit" class="btn btn-success" value="确定">
    	</form>
    </div>
    
    
    <c:if test="${!empty requestScope.ClassScore}">
	    <div id="center_3">   
	   		 <table class="table table-hover">
	    		<thead>
					<th>考场</th>
					<th>学号</th>
					<th>科目</th>
					<th>成绩</th>
				</thead>
				<tbody>			
		    		<c:forEach items="${requestScope.ClassScore}" var="x">
		    			<tr>
		    				<td>${x.rid}</td>
		    				<td>${x.sid}</td>
		    				<td>${x.itemName}</td>
		    				<td>${x.score}</td>
		    			</tr>
		    		</c:forEach>
	    		</tbody>
	    	</table>  	
	    </div>
    </c:if>
   </div>
  </body>
</html>
