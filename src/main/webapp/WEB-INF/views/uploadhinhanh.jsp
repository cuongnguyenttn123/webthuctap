<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
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
                <form id="form-baiviet" action="/api/themhinhanh" method="post">
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                        <h3>Thêm/Update Hình Ảnh:</h3>
                        <div class="form-group">
                            <input type="file" name="hinhanh" id="hinhanh" class="form-control">
                            <input type="hidden" name="tenhinhanh" value="">
                            <input type="hidden" name="idBaiViet" value="${idBaiViet}">
                            <button id="themhinhanh" type="submit" class="btn btn-primary">Thêm/Update Hình Ảnh</button>

                        </div>
                    </div>

                </form>
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>