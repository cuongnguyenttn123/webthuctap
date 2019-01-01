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
            <c:forEach items="${listBV}" var="baiViet">
                <div class="row">
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <article class="tinmoi">
                            <img src="<c:url value="/resources/Images/baiviet/${baiViet.getHinhAnh()}"/>" alt="">
                            <div class="tinmoind">
                                <h4>${baiViet.getTenBaiViet()}</h4>
                                <h5>${baiViet.getChuThich()} ...<a href="/baiviet/${baiViet.getId()}">xem tiep</a></h5>
                            </div>
                        </article>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
</body>
</html>
