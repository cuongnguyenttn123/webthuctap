<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Trang Admin</title>

</head>
<body >
<jsp:include page="../navbarmenu.jsp"/>
<!--bat dau phan than -->
<div class="container">
    <div class="row">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <ul class="list-group">
                <li class="list-group-item"><a href=""></a>
                    <ul class="list-group">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Minna<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/N5">N5</a></li>
                                <li><a href="/admin/N4">N4</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="list-group-item"><a href=""></a>
                    <ul class="list-group">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Bài Viết</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>

        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
            <c:forEach var="grammar" items="${gram}">
                <iframe width="750" height="480" src="${grammar.getUrl()}" frameborder="0"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>

                </iframe>
                ${grammar.getNoiDung()}
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
