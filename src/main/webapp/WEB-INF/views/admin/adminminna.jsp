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
    <div class="left-content">
        <div class="mother-grid-inner">
            <div id="header1" class="nav3">
                <jsp:include page="navbarmenu.jsp"/>

            </div>
        </div>
    </div>
    <!--/content-inner-->
    <div class="container">
        <div class="row">

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <form id="form-lession" action="/admin/minna/themtuvung/${list.getId()}" method="post">
                        <h3>Từ Vựng Minna:</h3>
                        <div class="form-group">
                            <label for="tuVung">Tên Từ Vựng: </label>
                            <input class="form-control" name="tuVung" id="tuVung">

                            <label for="kanJi">Kanji: </label>
                            <input class="form-control" name="kanJi" id="kanJi">

                            <label for="phienAm">Phiên Âm: </label>
                            <input class="form-control" name="phienAm" id="phienAm">

                            <label for="nghia">Nghĩa: </label>
                            <input class="form-control" name="nghia" id="nghia">

                            <br/>
                            <button id="xulytuvung" type="submit" class="btn btn-primary">Thêm Từ Vựng</button>
                            <button id="xulyupdatetuvung"  class="btn btn-primary hidden">Update Từ Vựng</button>
                            <button id="xulythoattuvung"  class="btn btn-primary hidden">Thoát</button>
                        </div>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                </div>




            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12　col-lg-12  ">
                        <table class="table" id="table-tuvung" style="width: 650px;">
                            <thead>
                            <tr>
                                <td>Tên Từ Vựng</td>
                                <td>Kanji</td>
                                <td>Phiên Âm</td>
                                <td>Nghĩa</td>
                                <td>Ví Dụ</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="tuvung" items="${voca}">
                                <tr>
                                    <td>${tuvung.getTuVung()}</td>
                                    <td>${tuvung.getKanJi()}</td>
                                    <td>${tuvung.getPhienAm()}</td>
                                    <td>${tuvung.getNghia()}</td>
                                    <td class="idlession" data-id="${tuvung.getId()}" data-idbaihoc="${list.getId()}" >
                                        <button class="updatetuvung btn btn-primary">CS</button> ||
                                        <a href="/admin/minna/xoa/tuvung/${tuvung.getId()}">Xóa</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">

            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <form id="form-lession1" action="/admin/minna/themnguphap/${list.getId()}" method="post">
                    <h3>Ngữ Pháp Minna:</h3>
                    <div class="form-group">
                        <label for="tenNguPhap">Tên Ngữ Pháp: </label>
                        <input class="form-control" name="tenNguPhap" id="tenNguPhap">

                        <label for="url">Url: </label>
                        <input class="form-control" name="url" id="url">

                        <label for="noiDung">Nội Dung: </label>
                        <input class="form-control" name="noiDung" id="noiDung">
                        <br/>
                        <button id="xulynguphap" type="submit" class="btn btn-primary">Thêm Ngữ Pháp</button>
                        <button id="xulyupdatenguphap"  class="btn btn-primary hidden">Update Ngữ Pháp</button>
                        <button id="xulythoatnguphap"  class="btn btn-primary hidden">Thoát</button>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>




            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12　col-lg-12  ">
                        <table class="table" id="table-nguphap" style="width: 650px;">
                            <thead>
                            <tr>
                                <td>Tên Ngữ Pháp</td>
                                <td>Url</td>
                                <td>Nội Dung</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="nguphap" items="${nguphap}">
                                <tr>
                                    <td>${nguphap.getTenNguPhap()}</td>
                                    <td>${nguphap.getUrl()}</td>
                                    <td>${nguphap.getNoiDung()}</td>
                                    <td class="idnguphap" data-id="${nguphap.getId()}" data-idbaihoc = "${list.getId()}" >
                                        <button class="updatenguphap btn btn-primary">CS</button> ||
                                        <a href="/admin/minna/xoa/nguphap/${nguphap.getId()}">Xóa</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <button class="btn btn-primary"><a href="/admin">Back</a></button>
        <br/>
        <br/>

    </div>
    <jsp:include page="../footer.jsp"/>
    <!--//content-inner-->
    <!--/sidebar-menu-->

</body>
</html>