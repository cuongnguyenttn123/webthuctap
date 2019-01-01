<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Bài Viết</title>

</head>
<body >
<jsp:include page="../navbarmenu.jsp"/>
<!--bat dau phan than -->
<div class="container">
    <div class="row">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">

        </div>

        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <h3>${baiviet.getTenBaiViet()}</h3>
            <br/>
            <br/>
            <p>${baiviet.getNoiDung()}</p>

        </div>
    </div>
</div>
</body>
</html>
