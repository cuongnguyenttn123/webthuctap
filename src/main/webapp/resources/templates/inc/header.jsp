<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
        <title>SEARCH-MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="<%=request.getContextPath() %>/resources/templates/css/stlye-table.css" rel="stylesheet" />
		<script src="<%=request.getContextPath() %>/resources/templates/js/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/resources/templates/js/bootstrap.min.js"></script>
		<link href="<%=request.getContextPath() %>/resources/templates/css/bootstrap.min.css" rel="stylesheet"/>
		<style> 
			input[type=text] {
				width: 50%;
				box-sizing: border-box;
				border: 2px solid #ccc;
				border-radius: 4px;
				font-size: 16px;
				background-color: white;
				background-image: url('searchicon.png');
				background-position: 10px 10px; 
				background-repeat: no-repeat;
				padding: 12px 20px 12px 40px;
				-webkit-transition: width 0.4s ease-in-out;
				transition: width 0.4s ease-in-out;
			}
</style>

</head>
<!------ Include the above in your HEAD tag ---------->
<body style="background: beige;">
<div class="container" style=" padding-top: 8%;">
	
    <div class="row col-md-6 col-md-offset-2 custyle">
    <%
    	if(session.getAttribute("UserInfo")!=null){
    		User userInfo=(User)session.getAttribute("UserInfo");%>
     <a href="<%=request.getContextPath()%>/logout">
                <i class="fa fa-power-off"></i>
                <p class="btn btn-success">Đăng xuất</p>
            </a>		
	<h3>Hello,<%=userInfo.getFullname()%> </h3>
	<form action="<%=request.getContextPath() %>/search" method="post">
		<input type="text" name="key" placeholder="Search.." required="required">
		<button type="submit" class="btn btn-success" >Search</button>
	</form>
	<% }%>