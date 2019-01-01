<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 11/22/2018
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chủ</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="header" class="nav3">
    <jsp:include page="navbarmenu.jsp"/>
    <div class="row slogan">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <h3><b>HỆ THỐNG HỌC TIẾNG NHẬT TOÀN DIỆN <br> <br>
                DÀNH CHO NGƯỜI MỚI BẮT ĐẦU </b></h3>

        </div>

    </div>
</div>
<div class="container">
    <hr class="thegach">
    <div class="row">
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInLeft" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="../resources/Images/banner1.jpg" alt="">
                <div class="caption text-center">

                    <p>
                        Giúp bạn xây dựng một nền tảng tiếng Nhật vững chắc
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInDown" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="../resources/Images/banner2.jpg" alt="">
                <div class="caption text-center">

                    <p>
                        Đồng hành cùng bạn ngay từ những bước đầu tiên của hành trình học tiếng Nhật
                    </p>

                </div>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInRight" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="../resources/Images/banner3.jpg" alt="">
                <div class="caption text-center">

                    <p>
                        Giúp bạn từng bước xây dựng cho mình 1 lộ trình học tập rõ ràng
                    </p>

                </div>
            </div>
        </div>

    </div>

    <hr class="thegach">
    <div class="row">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
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

        </div>
    </div>
    <div class="row">
        <ul class="pagination pagination-sm">
            <c:forEach var="i" begin="1" end="${tongsopage}">
                <c:choose>
                    <c:when test="${i==1}">
                        <li class="active"><a href="#">${i}</a></li>
                    </c:when>

                    <c:otherwise>
                        <li><a href="#">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

        </ul>
    </div>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
