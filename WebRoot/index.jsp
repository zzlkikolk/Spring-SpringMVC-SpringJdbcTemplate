<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>Login</title>
    <meta charset="utf-8"> 
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style>
    	#main{
    		width:300px;
    		height: 300px;
    		margin: auto;
    	}
    	#login{
    		text-align: center;
    		font-size: 18px;
    		font-weight: bold;
    	}
    	#low{
    		font-weight: bold;
    	}
    </style>
  </head>
  
  <body>
  <div id="main" class="panel panel-success">

  
  <div class="panel-heading" id="login">登录系统</div>
  <span class="text-danger" id="low">${requestScope.win }</span>
   <span class="text-danger">${requestScope.low }</span>
  <div class="panel-body">
   <form action="Login" method="post"> 
   		<span class="text-success">账户</span><input type="text" name="id" class="form-control"><br>
   		<span class="text-success">密码</span><input type="password" name="password" class="form-control"><br>
   		<span class="text-success">学生</span><input type="radio" name="level" value="1">
        <span class="text-success">老师</span><input type="radio" name="level" value="2">
        <span class="text-success">管理员</span><input type="radio" name="level" value="3">
   	        <input type="submit" value="登录" class=" btn btn-success btn active">
   </form>
   没有账户？ 注册<a href="register.html">点这里</a>
   </div>
   </div>
  </body>
</html>
