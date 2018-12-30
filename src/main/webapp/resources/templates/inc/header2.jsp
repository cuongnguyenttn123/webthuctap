<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <script src="<%=request.getContextPath() %>/resources/templates/js/jquery-1.11.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/resources/templates/js/bootstrap.min.js"></script>
		<link href="<%=request.getContextPath() %>/resources/templates/css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/templates/css/style.css" />
		<script src="<%=request.getContextPath() %>/resources/templates/js/cufon-yui.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath() %>/resources/templates/js/ChunkFive_400.font.js" type="text/javascript"></script>
    </head>
    <body>
    	<div style=" margin: 30px 37%;">
    		 <%
    	if(session.getAttribute("UserInfo")!=null){
    		User userInfo=(User)session.getAttribute("UserInfo");%>
  		   <a href="<%=request.getContextPath()%>/logout">
                <i class="fa fa-power-off"></i>
                <p class="btn btn-success">Đăng xuất</p>
            </a>		
		<h3>Hello,<%=userInfo.getFullname()%> </h3>
		<% }%>
    	</div>
    	<div style='clear:both'></div>