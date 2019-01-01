<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Admin Lession</title>
    <title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <jsp:include page="adminlib.jsp"/>
</head>
<body>
<div class="page-container">

    <div class="left-content">
        <div class="mother-grid-inner">
            <div id="header1" class="nav3">
                <jsp:include page="navbarmenu.jsp"/>

            </div>
        </div>
    </div>
    <!--/content-inner-->
    <div class="left-content">
        <div class="mother-grid-inner">

            <div class="container">
                <div class="row">
                    <form id="form-baiviet" action="/admin/baiviet/thembaiviet" method="post">
                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                            <h3>Bài Viết:</h3>
                            <div class="form-group">
                                <label for="tenBaiViet">Tên Bài Viết: </label>
                                <input class="form-control" name="tenBaiViet" id="tenBaiViet">

                                <label for="chuThich">Chú Thích Bài Học: </label>
                                <input class="form-control" name="chuThich" id="chuThich">

                                <label for="noiDung">Nội Dung Bài Học: </label>
                                <input class="form-control" name="noiDung" id="noiDung">

                                <input type="hidden" name="user" value="${pageContext.request.userPrincipal.name}">
                                <br/>
                                <button id="xulybaiviet" type="submit" class="btn btn-primary">Thêm Bài Viết</button>
                                <button id="xulyupdatebaiviet"  class="btn btn-primary hidden">Update Bài Viết</button>
                                <button id="xulythoatbaiviet"  class="btn btn-primary hidden">Thoát</button>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>

                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12　col-lg-12  ">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <td>Tên Bài Viết</td>
                                        <td>Chú Thích</td>
                                        <td>Nội Dung</td>
                                        <td>Tùy Chọn</td>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listBV}" var="baiviet">
                                        <tr>
                                            <td>${baiviet.getTenBaiViet()}</td>
                                            <td>${baiviet.getChuThich()}</td>
                                            <td>${baiviet.getNoiDung()}</td>
                                            <td class="idbaiviet" data-id="${baiviet.getId()}" >
                                                <button class="updatebaiviet btn btn-primary">CS</button> ||
                                                <a href="/admin/baiviet/xoa/${baiviet.getId()}">Xóa</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="../footer.jsp"/>
        </div>
    </div>
    <!--//content-inner-->
    <!--/sidebar-menu-->
    <jsp:include page="adminleft.jsp"/>
</div>
<jsp:include page="adminfooter.jsp"/>
</body>
</html>