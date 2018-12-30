
<%--
  Created by IntelliJ IDEA.
  User: cuong
  Date: 11/22/2018
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../header.jsp"/>
    <title>Từ Vựng</title>

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
            <div class="col-xs-8 col-sm-8 col-md-8　col-md-offset-2　col-lg-8 col-lg-offset-2 ">
                <table class="table">
                    <thead>
                    <tr>
                        <td>Tên Từ Vựng</td>
                        <td>Kanji</td>
                        <td>Phiên Âm</td>
                        <td>Nghĩa</td>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="tuvung" items="${voca}">
                        <tr>
                            <td>${tuvung.getTuVung()}</td>
                            <td>${tuvung.getKanJi()}</td>
                            <td>${tuvung.getPhienAm()}</td>
                            <td>${tuvung.getNghia()}</td>

                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
