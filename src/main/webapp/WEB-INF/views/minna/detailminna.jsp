<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Detail Minna</title>

</head>
<body >
    <jsp:include page="../navbarmenu.jsp"/>
<!--bat dau phan than -->
<div class="container">
    <div class="row">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <ul class="list-group">
                <c:forEach items="${list}" var="lession">
                    <li class="list-group-item"><a href=""></a>
                        <ul class="list-group">
                            <li>
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${lession.getTenBaiHoc()} : ${lession.getChuThich()}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/minna/lession/tuvung/${level}/${lession.getId()}">Từ Vựng</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/minna/lession/nguphap/${level}/${lession.getId()}">Ngữ Pháp</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </c:forEach>

            </ul>
        </div>

        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <div class="row">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/tuvung.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Từ Vựng</h3>
                        </div>
                    </div>
                </div>

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/nguphap.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Ngữ Pháp</h3>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/luyendoc.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Luyện Đọc</h3>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/hoithoai.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Hội Thoại</h3>
                        </div>
                    </div>
                </div>

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/luyennghe.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Luyện Nghe</h3>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/baitap.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Bài Tập</h3>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/hantu.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Hán Tự</h3>
                        </div>
                    </div>
                </div>

                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/kiemtra.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Kiểm Tra</h3>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="thumbnail canchuan">
                        <img class="tag_icon" src="../resources/Images/minna/thamkhao.jfif" alt="">
                        <div class="caption text-center">
                            <h3>Tham Khảo</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
