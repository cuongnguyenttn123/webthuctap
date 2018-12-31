<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Ngữ Pháp</title>

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
                        <ul class="list-group thea">
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

                <c:forEach var="nguphap" items="${nguphap}">
                    <iframe width="750" height="480" src="${nguphap.getUrl()}" frameborder="0"
                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>

                    </iframe>

                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>

                    ${nguphap.getNoiDung()}
                </c:forEach>

        </div>
    </div>
</div>
</body>
</html>
