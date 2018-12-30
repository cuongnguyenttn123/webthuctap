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

    <link href="../../resources/admin/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="../../resources/admin/css/style.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="../../resources/admin/css/morris.css" type="text/css"/>
    <!-- Graph CSS -->
    <link href="../../resources/admin/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="../../resources/admin/js/jquery-2.1.4.min.js"></script>
    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href="../../resources/admin/css/icon-font.min.css" type='text/css' />
    <!-- //lined-icons -->
</head>
<body>
<div class="page-container">
    <!--/content-inner-->
    <div class="left-content">
        <div class="mother-grid-inner">

            <div class="container">
                <div class="row">
                    <form id="form-lession" action="/admin/thembaihoc" method="post">
                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                            <h3>Bài Học Minna:</h3>
                            <div class="form-group">
                                <label for="tenBaiHoc">Tên Bài Học: </label>
                                <input class="form-control" name="tenBaiHoc" id="tenBaiHoc">

                                <label for="chuThich">Chú Thích Bài Học: </label>
                                <input class="form-control" name="chuThich" id="chuThich">

                                <label for="level">Cấp Độ: </label>
                                <input class="form-control" name="level" id="level">
                                <br/>
                                <button id="xuly" type="submit" class="btn btn-primary">Thêm Bài Học</button>
                                <button id="xulyupdate"  class="btn btn-primary hidden">Update Bài Học</button>
                                <button id="xulythoat"  class="btn btn-primary hidden">Thoát</button>
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
                                        <td>Tên Bài Học</td>
                                        <td>Chú Thích</td>
                                        <td>Level</td>
                                        <td>Tùy Chọn</td>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="lession">
                                        <tr>
                                            <td>${lession.getTenBaiHoc()}</td>
                                            <td>${lession.getChuThich()}</td>
                                            <td>${lession.getLevel()}</td>
                                            <td class="idlession" data-id="${lession.getId()}" ><button class="update btn btn-primary">CS</button> ||
                                                <button class="updatenoidung btn btn-primary">
                                                    <a href="/admin/minna/chinhhsua/${lession.getId()}">CS Nội Dung</a></button> ||
                                                <a href="/admin/xoa/${lession.getId()}">Xóa</a></td>
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