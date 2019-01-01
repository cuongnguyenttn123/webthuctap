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
            <c:if test="${empty listBV}">

                <h3>Không có bài viết nào</h3>
            </c:if>

            <c:if test="${not empty listBV}">
            <c:forEach items="${listBV}" var="baiViet">
                <div class="row">
                    <article class="tinmoi">
                        <img style="width: 335px;height: 200px;" src="<c:url value="/resources/Images/baiviet/${baiViet.getTenHinhAnh()}"/>" alt="">
                        <div class="tinmoind">
                            <h4>${baiViet.getTenBaiViet()}</h4>
                            <h5>${baiViet.getChuThich()} ...<a href="/baiviet/${baiViet.getId()}">xem tiep</a></h5>
                        </div>
                    </article>
                </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
